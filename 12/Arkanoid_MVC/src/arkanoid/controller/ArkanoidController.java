package arkanoid.controller;

import arkanoid.model.Level;
import arkanoid.model.Ball;
import arkanoid.model.Paddle;
import arkanoid.view.GameEngine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Logger;
import javax.swing.Timer;

public class ArkanoidController implements KeyListener, ActionListener {

    private GameEngine view;
    private Level level;
    private Ball ball;
    private Paddle paddle;
    private Timer newFrameTimer;
    private boolean paused = false;
    private int levelNum = 0;

    public ArkanoidController(GameEngine view) {
        this.view = view;
        this.view.addKeyListener(this);
        this.view.setFocusable(true);
        this.view.requestFocusInWindow(); // Ensure the component has focus
        restart();
        newFrameTimer = new Timer(1000 / view.getFPS(), this);
        newFrameTimer.start();
    }

    public void restart() {
        try {
            level = new Level("data/levels/level0" + levelNum + ".txt");
        } catch (IOException ex) {
            Logger.getLogger(GameEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        ball = new Ball(400, 300, view.getBallRadius(), view.getBallRadius(), view.getBallImage());
        paddle = new Paddle(350, view.getPaddleY(), view.getPaddleWidth(), view.getPaddleHeight(), view.getPaddleImage());
        view.setLevel(level);
        view.setBall(ball);
        view.setPaddle(paddle);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!paused) {
            ball.moveX();
            if (level.collides(ball)) {
                ball.invertVelX();
            }
            if (!ball.moveY()) {
                levelNum = 0;
                restart();
            }
            if (level.collides(ball)) {
                ball.invertVelY();
            }
            if (paddle.collides(ball)) {
                ball.invertVelY();
            }
            paddle.move();
        }
        if (level.isOver()) {
            levelNum = (levelNum + 1) % 2;
            restart();
        }
        view.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                paddle.setVelx(-view.getPaddleMovement());
                break;
            case KeyEvent.VK_RIGHT:
                paddle.setVelx(view.getPaddleMovement());
                break;
            case KeyEvent.VK_DOWN:
                paddle.setVelx(0);
                break;
            case KeyEvent.VK_ESCAPE:
                paused = !paused;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // No action needed
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No action needed
    }
}