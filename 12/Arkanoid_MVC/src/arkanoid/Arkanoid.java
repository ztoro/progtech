package arkanoid;

import arkanoid.view.ArkanoidGUI;
import arkanoid.view.GameEngine;
import arkanoid.controller.ArkanoidController;

public class Arkanoid {
    public static void main(String[] args) {
        ArkanoidGUI gui = new ArkanoidGUI();
        GameEngine gameEngine = new GameEngine();
        new ArkanoidController(gameEngine);
        gui.add(gameEngine);
        gui.setVisible(true); // Ensure the GUI is visible
        gameEngine.requestFocusInWindow(); // Request focus for the game engine
    }
}