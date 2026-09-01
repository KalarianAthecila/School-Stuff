package dev.kalarianathecila.schoolStuff.tutelini;

import java.awt.*;

public class MainPanel extends Panel {
    private Turtle tutel = null;
    private final int scale;

    public MainPanel() {
        this(1);
    }

    public MainPanel(int scale) {
        this.scale = Math.max(1, scale);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        this.tutel = new Turtle(this, g);
        drawHouseOfNicholas(scale);
    }

    public void draw() {
        tutel.homePosition();
        tutel.turnLeft(90);
        tutel.move(100);
    }

    public void drawHouseOfNicholas() {
        drawHouseOfNicholas(1);
    }

    public void drawHouseOfNicholas(int inputScale) {
        int normalizedScale = Math.max(1, inputScale);

        tutel.homePosition();

        // Original stroke order, with scalable line lengths.
        tutel.move(100 * normalizedScale);

        tutel.turnLeft(90);
        tutel.move(100 * normalizedScale);

        tutel.turnLeft(137);
        tutel.move(137 * normalizedScale);

        tutel.turnRight(137);
        tutel.move(100 * normalizedScale);

        tutel.turnRight(45);
        tutel.move(67 * normalizedScale);

        tutel.turnRight(90);
        tutel.move(66 * normalizedScale);

        tutel.turnRight(135);
        tutel.move(94 * normalizedScale);

        tutel.turnLeft(133);
        tutel.move(150 * normalizedScale);
    }
}
