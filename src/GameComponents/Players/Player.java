package GameComponents.Players;

import java.awt.Color;
import java.awt.Graphics2D;

import GameComponents.GamePanel;
import GameComponents.Title.Title;
import Utilities.HitBox;
import Utilities.Image;
import Utilities.Tool;

public class Player {

    public final int TANK_SIZE = 60;
    public final int BUFF_TIME = 1000;
    public final int BULLET_CD = 350;
    public final int MAX_BULLET = 10;

    private boolean inUse;
    private GamePanel gamePanel;
    private int id, angle = 0, direction, cd;
    private double x, y;
    private double numberAngle = 256;

    private double speed = 2.0, s_speed = 2.0;
    private Image body;
    private int timeTick = 0;
    private boolean isMove = false;
    int changeAngle;
    protected int checkTitle = -1;

    private HitBox hitBox;
    private int buffTime;
    private int bulletNumber = MAX_BULLET;
    private int bullet_cd = 0;

    public void statReset() {
        speed = s_speed;
    }

    public void checkBuffTime() {
        buffTime = buffTime - 1;
        if (buffTime <= 0) {
            buffTime = 0;
            statReset();
        }
    }

    public void setMovementSpeed(double speed) {
        buffTime = BUFF_TIME;
        this.speed = speed;
    }

    public int getID() {
        return id;
    }

    public boolean inUse() {
        if (cd > 0)
            return false;
        return inUse;
    }

    public HitBox getHitBox() {
        return hitBox;
    }

    public void destroy() {
        cd = 1000;
    }

    public Player(GamePanel gamePanel, int id) {
        inUse = false;
        this.gamePanel = gamePanel;
        this.id = id;
        body = new Image("../Assets/Images/Tank/body.png", TANK_SIZE, TANK_SIZE, 1);

    }

    public void create(int x, int y) {
        inUse = true;
        this.x = x;
        this.y = y;
        hitBox = new HitBox(x, y, 5, 5, 50, 50);
    }

    private void changeAngle() {
        if (isMove) {
            timeTick = 0;
        } else {
            timeTick = timeTick + 1;
            if (timeTick == 1) {
                timeTick = 0;
                if (changeAngle == 1) {
                    angle = angle + 1;
                } else {
                    angle = angle - 1;

                }
                if (angle == numberAngle - 1)
                    angle = 0;
            }
        }
    }

    private void changeDirection() {
        direction = angle;
    }

    public void move() {

        double angleRad = Math.toRadians(-90 + angle * 360 / numberAngle); // Chuyển đổi góc thành radian
        double dx = speed * Math.cos(angleRad); // Tính toán thay đổi tọa độ x
        double dy = speed * Math.sin(angleRad); // Tính toán thay đổi tọa độ y
        if (x >= 0 && x <= gamePanel.SCREEN_WIDTH - TANK_SIZE && y >= 0 && y <= gamePanel.SCREEN_HEIGHT - TANK_SIZE) {
            x = x + dx;
            y = y + dy;
            hitBox.update((int) x, (int) y);
        } else {
            if (x < 0) {
                x = 0;
            }
            if (y < 0) {
                y = 0;
            }
            if (x > gamePanel.SCREEN_WIDTH - TANK_SIZE) {
                x = gamePanel.SCREEN_WIDTH - TANK_SIZE;
            }
            if (y > gamePanel.SCREEN_HEIGHT - TANK_SIZE) {
                y = gamePanel.SCREEN_HEIGHT - TANK_SIZE;
            }
        }

        if (gamePanel.getCollisionChecker().objectCheck(this)) {
            x = x - dx;
            y = y - dy;
            hitBox.update((int) x, (int) y);
        }
    }

    public void shoot() {
        if (bulletNumber <= 0)
            return;
        bulletNumber = bulletNumber - 1;
        isMove = true;
        if (cd == 0)
            gamePanel.getBulletManager().create(id, direction, (int) x, (int) y);
    }

    public void update() {
        // if (id == 0)
        //     System.out.println(speed);

        checkTitle = gamePanel.getCollisionChecker().tankCheckTitle(this);

        double dx = 0;
        double dy = 0;

        if (checkTitle != -1) {
            Title title = gamePanel.getTitleManager().getTitles()[checkTitle];

            if (checkTitle % 4 == 0) {
                if (Math.abs(y + 55 - title.getY()) <= 10 && title.getChange()) {
                    dy = -3;
                } else if ((Math.abs(y - title.getY() - title.getH()) <= 10) && title.getChange() == false) {
                    dy = 3;
                } else if (x < title.getX()) {
                    dx = -2;
                } else if (x > title.getX()) {
                    dx = 2;
                }

            }

            if (checkTitle % 4 == 1) {
                if (Math.abs(x - title.getX() - title.getW()) <= 10 && title.getChange()) {
                    dx = 3;
                } else if ((Math.abs(x + 55 - title.getX()) <= 10) && title.getChange() == false) {
                    dx = -3;
                } else if (y < title.getY()) {
                    dy = -2;
                } else if (y > title.getY()) {
                    dy = 2;
                }

            }

            if (checkTitle % 4 == 2) {
                if (Math.abs(y + 55 - title.getY()) <= 10 && title.getChange() == false) {
                    dy = -3;
                } else if ((Math.abs(y - title.getY() - title.getH()) <= 10) && title.getChange()) {
                    dy = 3;
                } else if (x < title.getX()) {
                    dx = -2;
                } else if (x > title.getX()) {
                    dx = 2;
                }

            }

            if (checkTitle % 4 == 3) {
                if (Math.abs(x - title.getX() - title.getW()) <= 10 && title.getChange() == false) {
                    dx = 3;
                } else if ((Math.abs(x + 55 - title.getX()) <= 10) && title.getChange()) {
                    dx = -3;
                } else if (y < title.getY()) {
                    dy = -2;
                } else if (y > title.getY()) {
                    dy = 2;
                }

            }
            // System.out.println(" " + y + " " + title.getY());
        }

        x += dx;
        y += dy;
        hitBox.update((int) x, (int) y);

        if (inUse && checkTitle == -1) {
            checkBuffTime();

            // Bullet number

            if (bulletNumber < MAX_BULLET) {
                bullet_cd = bullet_cd + 1;
                if (bullet_cd == BULLET_CD) {
                    bullet_cd = bulletNumber = bulletNumber + 1;
                }
            } else {
                bullet_cd = 0;
            }

            // ------

            cd = cd - 1;
            if (cd < 0)
                cd = 0;
            if (cd == 1) {
                bulletNumber = MAX_BULLET;
            }

            if (cd == 0) {
                changeAngle();
                changeDirection();
                if (gamePanel.getKeyHandler().isOnePressed(id)) {
                    isMove = true;
                    if (!gamePanel.getKeyHandler().checkDoublePress(id)) {
                        move();
                        if (changeAngle == 0) {
                            changeAngle = 1;
                        } else {
                            changeAngle = 0;
                        }
                    }

                } else if (cd != 1) {
                    if (!gamePanel.getKeyHandler().checkDoublePress(id) && gamePanel.getKeyHandler().waitXTime(id)) {
                        isMove = false;
                    }

                }

            }

        }
        gamePanel.getCollisionChecker().tankCheck(this);
    }

    public void render(Graphics2D graphics2d) {
        if (inUse) {
            if (cd == 0) {
                graphics2d.setColor(Color.RED);
                graphics2d.setFont(graphics2d.getFont().deriveFont(20F));
                int intX = (int) x; // Chuyển đổi tọa độ x thành int
                int intY = (int) y; // Chuyển đổi tọa độ y thành int
                // graphics2d.drawString("PLAYER " + (id + 1), intX - 10, intY);

                if (isMove) {
                    graphics2d.drawImage(Tool.rotateImage(body.getImage(), direction * 360 / numberAngle), intX, intY,
                            body.getWidth(), body.getHeight(), null);

                } else {
                    graphics2d.drawImage(Tool.rotateImage(body.getImage(), angle * 360 / numberAngle), intX, intY,
                            body.getWidth(), body.getHeight(), null);

                }

                for (int i = 0; i < bulletNumber; ++i) {
                    graphics2d.fillRect(intX - 3 + i * 7, intY + 3, 5, 5);
                }

                if (buffTime > 0) {
                    Double percent = 1.0 * buffTime / BUFF_TIME;
                    graphics2d.fillRect(intX - 8, intY + 3, (int) (percent * 80), 5);
                }

                hitBox.render(graphics2d);

            } else {
                graphics2d.setColor(Color.BLACK);
                graphics2d.setFont(graphics2d.getFont().deriveFont(30F));
                graphics2d.drawString(String.valueOf(cd / 100), (int) x + 30, (int) y + 30);
            }
        }
    }
}