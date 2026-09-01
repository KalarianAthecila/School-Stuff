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
        int levels = Math.max(1, inputScale);

        int panelHeight = Math.max(200, getHeight());
        int bottomMargin = 40;

        int trunkLength = Math.max(60, panelHeight / 4);
        int baseBranchLength = Math.max(35, trunkLength * 2 / 3);

        tutel.homePosition();

        // Start near bottom-center, then face upward.
        tutel.stopDraw();
        tutel.turnRight(90);
        tutel.move((panelHeight / 2.0) - bottomMargin);
        tutel.turnLeft(180);
        tutel.startDraw();

        // Draw trunk.
        tutel.move(trunkLength);

        // Base split is always drawn; extra levels recurse from branch tips.
        drawTreeSplit(baseBranchLength, levels - 1);
    }

    private void drawTreeSplit(double branchLength, int extraLevels) {
        if (branchLength < 6) {
            return;
        }

        // Left branch (+30 deg from vertical).
        tutel.turnLeft(30);
        tutel.move(branchLength);
        if (extraLevels > 0) {
            drawTreeSplit(branchLength * 0.7, extraLevels - 1);
        }
        tutel.back((int) Math.round(branchLength));

        // Right branch (-30 deg from vertical), so both branches are 60 deg apart.
        tutel.turnRight(60);
        tutel.move(branchLength);
        if (extraLevels > 0) {
            drawTreeSplit(branchLength * 0.7, extraLevels - 1);
        }
        tutel.back((int) Math.round(branchLength));

        // Restore original heading before returning.
        tutel.turnLeft(30);
    }
}
