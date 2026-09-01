package dev.kalarianathecila.schoolStuff.tutelini;

import java.awt.*;

public class MainPanel extends Panel {
    private static final int MAX_TREE_LEVELS = 12;
    private static final int MAX_KOCH_LEVELS = 6;
    private static final int MAX_SIERPINSKI_LEVELS = 7;
    private static final int MAX_DRAGON_LEVELS = 16;

    public enum DrawingTarget {
        HOUSE,
        TREE,
        KOCH_SNOWFLAKE,
        SIERPINSKI_TRIANGLE,
        DRAGON_CURVE
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
        switch (drawingTarget) {
            case TREE:
                drawTree(scale);
                break;
            case KOCH_SNOWFLAKE:
                drawKochSnowflake(scale);
                break;
            case SIERPINSKI_TRIANGLE:
                drawSierpinskiTriangle(scale);
                break;
            case DRAGON_CURVE:
                drawDragonCurve(scale);
                break;
            default:
                drawHouseOfNicholas(scale);
                break;
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
        int levels = clampLevel(inputScale, MAX_TREE_LEVELS);

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

    public void drawKochSnowflake(int inputLevels) {
        int levels = clampLevel(inputLevels, MAX_KOCH_LEVELS);
        double size = Math.min(getWidth(), getHeight()) * 0.35;
        if (size < 80) {
            size = 220;
        }

        tutel.homePosition();
        tutel.stopDraw();
        tutel.back((int) Math.round(size / 2.0));
        tutel.turnRight(90);
        tutel.move(size / 3.0);
        tutel.turnLeft(90);
        tutel.startDraw();

        for (int i = 0; i < 3; i++) {
            drawKochSegment(levels, size);
            tutel.turnRight(120);
        }
    }

    private void drawKochSegment(int level, double length) {
        if (level <= 1) {
            tutel.move(length);
            return;
        }

        double third = length / 3.0;
        drawKochSegment(level - 1, third);
        tutel.turnLeft(60);
        drawKochSegment(level - 1, third);
        tutel.turnRight(120);
        drawKochSegment(level - 1, third);
        tutel.turnLeft(60);
        drawKochSegment(level - 1, third);
    }

    public void drawSierpinskiTriangle(int inputLevels) {
        int levels = clampLevel(inputLevels, MAX_SIERPINSKI_LEVELS);
        double size = Math.min(getWidth(), getHeight()) * 0.6;
        if (size < 100) {
            size = 260;
        }

        tutel.homePosition();
        tutel.stopDraw();
        tutel.back((int) Math.round(size / 2.0));
        tutel.turnRight(90);
        tutel.move(size / 3.0);
        tutel.turnLeft(90);
        tutel.startDraw();

        drawSierpinskiRecursive(levels, size);
    }

    private void drawSierpinskiRecursive(int level, double length) {
        if (level <= 1) {
            drawTriangle(length);
            return;
        }

        double half = length / 2.0;

        drawSierpinskiRecursive(level - 1, half);

        tutel.move(half);
        drawSierpinskiRecursive(level - 1, half);
        tutel.back((int) Math.round(half));

        tutel.turnLeft(60);
        tutel.move(half);
        tutel.turnRight(60);
        drawSierpinskiRecursive(level - 1, half);
        tutel.turnRight(60);
        tutel.back((int) Math.round(half));
        tutel.turnLeft(60);
    }

    private void drawTriangle(double length) {
        for (int i = 0; i < 3; i++) {
            tutel.move(length);
            tutel.turnLeft(120);
        }
    }

    public void drawDragonCurve(int inputLevels) {
        int levels = clampLevel(inputLevels, MAX_DRAGON_LEVELS);
        double size = Math.min(getWidth(), getHeight()) * 0.45;
        if (size < 80) {
            size = 220;
        }

        tutel.homePosition();
        tutel.stopDraw();
        tutel.back((int) Math.round(size / 2.0));
        tutel.startDraw();

        drawDragonRecursive(levels, size, 1);
    }

    private void drawDragonRecursive(int level, double length, int sign) {
        if (level <= 1) {
            tutel.move(length);
            return;
        }

        double nextLength = length / Math.sqrt(2.0);
        drawDragonRecursive(level - 1, nextLength, 1);
        if (sign > 0) {
            tutel.turnLeft(90);
        } else {
            tutel.turnRight(90);
        }
        drawDragonRecursive(level - 1, nextLength, -1);
    }

    private int clampLevel(int input, int maxLevel) {
        return Math.min(maxLevel, Math.max(1, input));
    }
}
