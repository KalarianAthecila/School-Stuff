package dev.kalarianathecila.schoolStuff.tutelini;

import java.awt.*;

public class MainPanel extends Panel {
    public enum DrawingTarget {
        HOUSE,
        TREE
    }

    private Turtle tutel = null;
    private final int scale;
    private final DrawingTarget drawingTarget;

    public MainPanel() {
        this(1, DrawingTarget.HOUSE);
    }

    public MainPanel(int scale) {
        this(scale, DrawingTarget.HOUSE);
    }

    public MainPanel(int scale, DrawingTarget drawingTarget) {
        this.scale = Math.max(1, scale);
        this.drawingTarget = drawingTarget == null ? DrawingTarget.HOUSE : drawingTarget;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        this.tutel = new Turtle(this, g);
        if (drawingTarget == DrawingTarget.TREE) {
            drawTree(scale);
        } else {
            drawHouseOfNicholas(scale);
        }
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

    public void drawTree(int inputScale) {
        // Placeholder for upcoming tree implementation.
    }
}
