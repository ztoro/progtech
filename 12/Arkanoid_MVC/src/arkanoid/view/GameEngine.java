package arkanoid.view;

import arkanoid.model.Ball;
import arkanoid.model.Level;
import arkanoid.model.Paddle;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameEngine extends JPanel {

    private final int FPS = 240;
    private final int PADDLE_Y = 550;
    private final int PADDLE_WIDTH = 100;
    private final int PADDLE_HEIGHT = 20;
    private final int PADDLE_MOVEMENT = 2;
    private final int BALL_RADIUS = 20;

    private Image background;
    private Level level;
    private Ball ball;
    private Paddle paddle;

    public GameEngine() {
        super();
        background = new ImageIcon("data/images/background.jpg").getImage();
    }

    public int getFPS() {
        return FPS;
    }

    public int getPaddleY() {
        return PADDLE_Y;
    }

    public int getPaddleWidth() {
        return PADDLE_WIDTH;
    }

    public int getPaddleHeight() {
        return PADDLE_HEIGHT;
    }

    public int getPaddleMovement() {
        return PADDLE_MOVEMENT;
    }

    public int getBallRadius() {
        return BALL_RADIUS;
    }

    public Image getPaddleImage() {
        return new ImageIcon("data/images/paddle.png").getImage();
    }

    public Image getBallImage() {
        return new ImageIcon("data/images/ball.png").getImage();
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        grphcs.drawImage(background, 0, 0, 800, 600, null);
        level.draw(grphcs);
        paddle.draw(grphcs);
        ball.draw(grphcs);
    }
}