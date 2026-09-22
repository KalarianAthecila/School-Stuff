package dev.kalarianathecila.schoolStuff.tutelini;

import java.awt.*;

public class MainPanel extends Panel {
    private static final int MAX_TREE_LEVELS = 12;
    private static final int MAX_Y_TREE_LEVELS = 12;
    private static final int MAX_KOCH_LEVELS = 6;
    private static final int MAX_SIERPINSKI_LEVELS = 7;
    private static final int MAX_DRAGON_LEVELS = 16;

    private static final double BINARY_BRANCH_ANGLE = 30.0;
    private static final double BINARY_BRANCH_SCALE = 0.7;
    private static final double Y_BRANCH_ANGLE = 35.0;
    private static final double Y_BRANCH_SCALE = 0.72;
    private static final double MIN_BRANCH_ANGLE = 1.0;
    private static final double MAX_BRANCH_ANGLE = 89.0;
    private static final double MIN_LENGTH_MULTIPLIER = 0.2;
    private static final double MAX_LENGTH_MULTIPLIER = 3.0;

    public enum DrawingTarget {
        HOUSE,
        TREE,
        Y_TREE,
        KOCH_SNOWFLAKE,
        SIERPINSKI_TRIANGLE,
        DRAGON_CURVE
    }

    private Turtle tutel = null;
    private Graphics2D canvas = null;
    private final int scale;
    private final DrawingTarget drawingTarget;
    private double treeAngleOffset = 0.0;
    private double treeLengthMultiplier = 1.0;

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
        this.canvas = g instanceof Graphics2D ? (Graphics2D) g : null;
        switch (drawingTarget) {
            case TREE:
                drawTree(scale);
                break;
            case Y_TREE:
                drawYTree(scale);
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
        double trunkLength = moveToTreeStartAndDrawTrunk(treeLengthMultiplier);
        double firstBranchLength = Math.max(35.0, trunkLength * (2.0 / 3.0));
        double branchAngle = clampDouble(BINARY_BRANCH_ANGLE + treeAngleOffset, MIN_BRANCH_ANGLE, MAX_BRANCH_ANGLE);

        // Binary tree: each branch splits into two branches.
        drawBranchPair(firstBranchLength, levels - 1, branchAngle, BINARY_BRANCH_SCALE);
    }

    public void drawYTree(int inputLevels) {
        int levels = clampLevel(inputLevels, MAX_Y_TREE_LEVELS);
        double trunkLength = moveToTreeStartAndDrawTrunk(treeLengthMultiplier);
        double firstBranchLength = Math.max(35.0, trunkLength * 0.55);
        double firstStemLength = Math.max(30.0, trunkLength * 0.55);
        double branchAngle = clampDouble(Y_BRANCH_ANGLE + treeAngleOffset, MIN_BRANCH_ANGLE, MAX_BRANCH_ANGLE);

        // Y-tree: each split creates two arms, and each arm grows a vertical stem before the next split.
        drawYTreeNode(firstBranchLength, firstStemLength, branchAngle, levels - 1);
    }

    private double moveToTreeStartAndDrawTrunk(double lengthMultiplier) {
        double panelHeight = Math.max(200.0, getHeight());
        double bottomMargin = 40.0;
        double trunkLength = Math.max(60.0, (panelHeight / 4.0) * lengthMultiplier);

        tutel.homePosition();

        // Start near bottom-center, then face upward.
        tutel.stopDraw();
        tutel.turnRight(90);
        tutel.move((panelHeight / 2.0) - bottomMargin);
        tutel.turnLeft(180);
        tutel.startDraw();

        tutel.move(trunkLength);
        return trunkLength;
    }

    private void drawBranchPair(double branchLength, int extraLevels, double branchAngle, double shrinkFactor) {
        if (branchLength < 6.0) {
            return;
        }

        // Left branch from current heading.
        tutel.turnLeft(branchAngle);
        tutel.move(branchLength);
        if (extraLevels > 0) {
            drawBranchPair(branchLength * shrinkFactor, extraLevels - 1, branchAngle, shrinkFactor);
        }
        tutel.back(branchLength);

        // Right branch mirrored across the parent direction.
        tutel.turnRight(branchAngle * 2.0);
        tutel.move(branchLength);
        if (extraLevels > 0) {
            drawBranchPair(branchLength * shrinkFactor, extraLevels - 1, branchAngle, shrinkFactor);
        }
        tutel.back(branchLength);

        // Restore original heading before returning.
        tutel.turnLeft(branchAngle);
    }

    private void drawYTreeNode(double branchLength, double stemLength, double branchAngle, int extraLevels) {
        if (branchLength < 6.0 || stemLength < 6.0 || extraLevels < 0) {
            return;
        }

        // Left arm from current split point.
        tutel.turnLeft(branchAngle);
        tutel.move(branchLength);

        // Re-align to global up before drawing the next stem.
        tutel.turnRight(branchAngle);
        tutel.move(stemLength);
        if (extraLevels > 0) {
            drawYTreeNode(branchLength * Y_BRANCH_SCALE, stemLength * Y_BRANCH_SCALE, branchAngle, extraLevels - 1);
        }
        tutel.back(stemLength);
        tutel.turnLeft(branchAngle);
        tutel.back(branchLength);

        // Right arm mirrors the left arm from the same split point.
        tutel.turnRight(branchAngle * 2.0);
        tutel.move(branchLength);

        // Re-align to global up before drawing the next stem.
        tutel.turnLeft(branchAngle);
        tutel.move(stemLength);
        if (extraLevels > 0) {
            drawYTreeNode(branchLength * Y_BRANCH_SCALE, stemLength * Y_BRANCH_SCALE, branchAngle, extraLevels - 1);
        }
        tutel.back(stemLength);
        tutel.turnRight(branchAngle);
        tutel.back(branchLength);

        // Restore original heading before returning.
        tutel.turnLeft(branchAngle);
    }

    public void adjustTreeAngle(double deltaDegrees) {
        treeAngleOffset = clampDouble(treeAngleOffset + deltaDegrees, -45.0, 45.0);
        repaint();
    }

    public void adjustTreeLengthMultiplier(double delta) {
        treeLengthMultiplier = clampDouble(treeLengthMultiplier + delta, MIN_LENGTH_MULTIPLIER, MAX_LENGTH_MULTIPLIER);
        repaint();
    }

    public double getTreeAngleOffset() {
        return treeAngleOffset;
    }

    public double getTreeLengthMultiplier() {
        return treeLengthMultiplier;
    }

    public void drawKochSnowflake(int inputLevels) {
        if (canvas == null) {
            return;
        }

        int levels = clampLevel(inputLevels, MAX_KOCH_LEVELS);
        double size = Math.min(getWidth(), getHeight()) * 0.35;
        if (size < 80) {
            size = 220;
        }

        double centerX = getWidth() / 2.0;
        double centerY = getHeight() / 2.0;
        double triHeight = size * Math.sqrt(3.0) / 2.0;

        double ax = centerX - (size / 2.0);
        double ay = centerY + (triHeight / 3.0);
        double bx = centerX + (size / 2.0);
        double by = ay;
        double cx = centerX;
        double cy = centerY - (2.0 * triHeight / 3.0);

        drawKochEdge(levels, ax, ay, bx, by);
        drawKochEdge(levels, bx, by, cx, cy);
        drawKochEdge(levels, cx, cy, ax, ay);
    }

    private void drawKochEdge(int level, double x1, double y1, double x5, double y5) {
        if (level <= 1) {
            drawLine(x1, y1, x5, y5);
            return;
        }

        double dx = (x5 - x1) / 3.0;
        double dy = (y5 - y1) / 3.0;

        double x2 = x1 + dx;
        double y2 = y1 + dy;
        double x4 = x1 + 2.0 * dx;
        double y4 = y1 + 2.0 * dy;

        // Rotate by -60 degrees to put the bump outside the base triangle.
        double cos60 = 0.5;
        double sin60 = Math.sqrt(3.0) / 2.0;
        double vx = x4 - x2;
        double vy = y4 - y2;
        double x3 = x2 + (vx * cos60 + vy * sin60);
        double y3 = y2 + (-vx * sin60 + vy * cos60);

        drawKochEdge(level - 1, x1, y1, x2, y2);
        drawKochEdge(level - 1, x2, y2, x3, y3);
        drawKochEdge(level - 1, x3, y3, x4, y4);
        drawKochEdge(level - 1, x4, y4, x5, y5);
    }

    public void drawSierpinskiTriangle(int inputLevels) {
        if (canvas == null) {
            return;
        }

        int levels = clampLevel(inputLevels, MAX_SIERPINSKI_LEVELS);
        double size = Math.min(getWidth(), getHeight()) * 0.6;
        if (size < 100) {
            size = 260;
        }

        double centerX = getWidth() / 2.0;
        double centerY = getHeight() / 2.0;
        double triHeight = size * Math.sqrt(3.0) / 2.0;

        double ax = centerX;
        double ay = centerY - (2.0 * triHeight / 3.0);
        double bx = centerX - (size / 2.0);
        double by = centerY + (triHeight / 3.0);
        double cx = centerX + (size / 2.0);
        double cy = by;

        drawSierpinskiRecursive(levels, ax, ay, bx, by, cx, cy);
    }

    private void drawSierpinskiRecursive(int level,
                                         double ax, double ay,
                                         double bx, double by,
                                         double cx, double cy) {
        if (level <= 1) {
            drawLine(ax, ay, bx, by);
            drawLine(bx, by, cx, cy);
            drawLine(cx, cy, ax, ay);
            return;
        }

        double abx = (ax + bx) / 2.0;
        double aby = (ay + by) / 2.0;
        double bcx = (bx + cx) / 2.0;
        double bcy = (by + cy) / 2.0;
        double cax = (cx + ax) / 2.0;
        double cay = (cy + ay) / 2.0;

        drawSierpinskiRecursive(level - 1, ax, ay, abx, aby, cax, cay);
        drawSierpinskiRecursive(level - 1, abx, aby, bx, by, bcx, bcy);
        drawSierpinskiRecursive(level - 1, cax, cay, bcx, bcy, cx, cy);
    }

    public void drawDragonCurve(int inputLevels) {
        int levels = clampLevel(inputLevels, MAX_DRAGON_LEVELS);
        double size = Math.min(getWidth(), getHeight()) * 0.45;
        if (size < 80) {
            size = 220;
        }

        tutel.homePosition();
        tutel.stopDraw();
        tutel.turnLeft(180);
        tutel.move(size / 2.0);
        tutel.turnRight(180);
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

    private double clampDouble(double value, double minValue, double maxValue) {
        return Math.max(minValue, Math.min(maxValue, value));
    }

    private void drawLine(double x1, double y1, double x2, double y2) {
        if (canvas == null) {
            return;
        }

        canvas.drawLine(
                (int) Math.round(x1),
                (int) Math.round(y1),
                (int) Math.round(x2),
                (int) Math.round(y2)
        );
    }
}
