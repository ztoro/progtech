package arkanoid.view;

import javax.swing.JFrame;

public class ArkanoidGUI extends JFrame {
    public ArkanoidGUI() {
        setTitle("Arkanoid Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}