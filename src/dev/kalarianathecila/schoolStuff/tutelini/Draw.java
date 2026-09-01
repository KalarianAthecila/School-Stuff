package dev.kalarianathecila.schoolStuff.tutelini;

import javax.swing.*;

public class Draw extends JFrame {
    public static void main(String[] args) {
        Draw app = new Draw();

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(1920, 1080);
        app.setIconImage(new ImageIcon("src/dev/kalarianathecila/schoolStuff/tutelini/app_black.png").getImage());
        app.add(new MainPanel());
        app.setVisible(true);
    }
}
