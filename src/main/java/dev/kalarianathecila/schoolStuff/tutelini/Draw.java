package dev.kalarianathecila.schoolStuff.tutelini;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;
import com.formdev.flatlaf.FlatDarkLaf;

public class Draw extends JFrame {
    private static final int MIN_SPIN_DELAY_MS = 20_000;
    private static final int MAX_SPIN_DELAY_MS = 60_000;
    private static final int SPIN_FRAME_DELAY_MS = 180;
    private static final String[] TURTLE_ICON_PATHS = {
            "/dev/kalarianathecila/schoolStuff/tutelini/tutel.png",
            "/dev/kalarianathecila/schoolStuff/tutelini/tutel_90.png",
            "/dev/kalarianathecila/schoolStuff/tutelini/tutel_180.png",
            "/dev/kalarianathecila/schoolStuff/tutelini/tutel_270.png"
    };

    private Image[] turtleIcons;
    private int currentIconIndex;
    private int loadedIconCount;
    private boolean isSpinning;

    public static void main(String[] args) {
        FlatDarkLaf.setup();
        DrawSelection selection = readSelection(args);

        SwingUtilities.invokeLater(() -> {
            Draw app = new Draw();

            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            app.setSize(1920, 1080);

            app.initializeIconRotation();

            app.add(new MainPanel(selection.scale, selection.target));
            app.setVisible(true);
            app.scheduleNextIconSpin();
        });
    }

    private void initializeIconRotation() {
        this.turtleIcons = new Image[TURTLE_ICON_PATHS.length];

        for (int i = 0; i < TURTLE_ICON_PATHS.length; i++) {
            URL iconUrl = Draw.class.getResource(TURTLE_ICON_PATHS[i]);
            if (iconUrl != null) {
                turtleIcons[i] = new ImageIcon(iconUrl).getImage();
            }
        }

        loadedIconCount = 0;
        for (Image turtleIcon : turtleIcons) {
            if (turtleIcon != null) {
                loadedIconCount++;
            }
        }

        currentIconIndex = 0;
        isSpinning = false;
        if (turtleIcons[currentIconIndex] != null) {
            setIconImage(turtleIcons[currentIconIndex]);
        }
    }

    private void scheduleNextIconSpin() {
        int delay = ThreadLocalRandom.current().nextInt(MIN_SPIN_DELAY_MS, MAX_SPIN_DELAY_MS + 1);
        Timer timer = new Timer(delay, e -> startSpinAnimation());
        timer.setRepeats(false);
        timer.start();
    }

    private void startSpinAnimation() {
        if (isSpinning || turtleIcons == null || loadedIconCount < 2) {
            scheduleNextIconSpin();
            return;
        }

        isSpinning = true;
        final int[] completedSteps = {0};
        final int stepsForFullSpin = loadedIconCount;

        Timer animationTimer = new Timer(SPIN_FRAME_DELAY_MS, e -> {
            if (!advanceToNextAvailableIcon()) {
                ((Timer) e.getSource()).stop();
                isSpinning = false;
                scheduleNextIconSpin();
                return;
            }

            completedSteps[0]++;
            if (completedSteps[0] >= stepsForFullSpin) {
                ((Timer) e.getSource()).stop();
                isSpinning = false;
                scheduleNextIconSpin();
            }
        });
        animationTimer.start();
    }

    private boolean advanceToNextAvailableIcon() {
        if (turtleIcons == null || turtleIcons.length == 0) {
            return false;
        }

        for (int i = 0; i < turtleIcons.length; i++) {
            currentIconIndex = (currentIconIndex + 1) % turtleIcons.length;
            if (turtleIcons[currentIconIndex] != null) {
                setIconImage(turtleIcons[currentIconIndex]);
                return true;
            }
        }

        return false;
    }

    private static DrawSelection readSelection(String[] args) {
        Integer argScale = null;
        MainPanel.DrawingTarget argTarget = MainPanel.DrawingTarget.HOUSE;

        if (args != null && args.length > 0) {
            argScale = parseScale(args[0]);
        }

        if (args != null && args.length > 1) {
            argTarget = parseTarget(args[1]);
        }

        JTextField scaleField = new JTextField(String.valueOf(argScale != null ? argScale : 1), 8);
        JCheckBox houseCheck = new JCheckBox("House (value = scale)", argTarget == MainPanel.DrawingTarget.HOUSE);
        JCheckBox treeCheck = new JCheckBox("Tree (value = levels)", argTarget == MainPanel.DrawingTarget.TREE);
        JCheckBox kochCheck = new JCheckBox("Koch Snowflake (value = levels)", argTarget == MainPanel.DrawingTarget.KOCH_SNOWFLAKE);
        JCheckBox sierpinskiCheck = new JCheckBox("Sierpinski Triangle (value = levels)", argTarget == MainPanel.DrawingTarget.SIERPINSKI_TRIANGLE);
        JCheckBox dragonCheck = new JCheckBox("Dragon Curve (value = levels)", argTarget == MainPanel.DrawingTarget.DRAGON_CURVE);

        ButtonGroup group = new ButtonGroup();
        group.add(houseCheck);
        group.add(treeCheck);
        group.add(kochCheck);
        group.add(sierpinskiCheck);
        group.add(dragonCheck);

        JPanel standardPanel = new JPanel(new GridLayout(0, 1, 0, 4));
        standardPanel.setBorder(BorderFactory.createTitledBorder("Standard"));
        standardPanel.add(houseCheck);

        JPanel fractalPanel = new JPanel(new GridLayout(0, 1, 0, 4));
        fractalPanel.setBorder(BorderFactory.createTitledBorder("Fractals"));
        fractalPanel.add(treeCheck);
        fractalPanel.add(kochCheck);
        fractalPanel.add(sierpinskiCheck);
        fractalPanel.add(dragonCheck);

        JPanel panel = new JPanel(new GridLayout(0, 1, 0, 6));
        panel.add(new JLabel("Enter value (positive integer):"));
        panel.add(scaleField);
        panel.add(new JLabel("Fractals use level caps for stability (tree 12, koch 6, sierpinski 7, dragon 16)."));
        panel.add(new JLabel("Apply value to:"));
        panel.add(standardPanel);
        panel.add(fractalPanel);

        while (true) {
            int result = JOptionPane.showConfirmDialog(
                    null,
                    panel,
                    "Draw Settings",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (result != JOptionPane.OK_OPTION) {
                return new DrawSelection(argScale != null ? argScale : 1, argTarget);
            }

            Integer parsedScale = parseScale(scaleField.getText());
            if (parsedScale == null) {
                JOptionPane.showMessageDialog(
                        null,
                        "Please enter a positive integer.",
                        "Invalid Value",
                        JOptionPane.WARNING_MESSAGE
                );
                continue;
            }

            MainPanel.DrawingTarget target = treeCheck.isSelected()
                    ? MainPanel.DrawingTarget.TREE
                    : kochCheck.isSelected()
                    ? MainPanel.DrawingTarget.KOCH_SNOWFLAKE
                    : sierpinskiCheck.isSelected()
                    ? MainPanel.DrawingTarget.SIERPINSKI_TRIANGLE
                    : dragonCheck.isSelected()
                    ? MainPanel.DrawingTarget.DRAGON_CURVE
                    : MainPanel.DrawingTarget.HOUSE;

            return new DrawSelection(parsedScale, target);
        }
    }

    private static Integer parseScale(String value) {
        if (value == null) {
            return null;
        }

        try {
            int parsed = Integer.parseInt(value.trim());
            return parsed > 0 ? parsed : null;
        } catch (NumberFormatException ignored) {
            return null;
        }
    }

    private static MainPanel.DrawingTarget parseTarget(String value) {
        if (value == null) {
            return MainPanel.DrawingTarget.HOUSE;
        }

        String normalized = value.trim().toLowerCase();
        if ("tree".equals(normalized)) {
            return MainPanel.DrawingTarget.TREE;
        }
        if ("koch".equals(normalized) || "snowflake".equals(normalized) || "koch_snowflake".equals(normalized)) {
            return MainPanel.DrawingTarget.KOCH_SNOWFLAKE;
        }
        if ("sierpinski".equals(normalized) || "triangle".equals(normalized) || "sierpinski_triangle".equals(normalized)) {
            return MainPanel.DrawingTarget.SIERPINSKI_TRIANGLE;
        }
        if ("dragon".equals(normalized) || "dragon_curve".equals(normalized)) {
            return MainPanel.DrawingTarget.DRAGON_CURVE;
        }

        return MainPanel.DrawingTarget.HOUSE;
    }

    private static class DrawSelection {
        private final int scale;
        private final MainPanel.DrawingTarget target;

        private DrawSelection(int scale, MainPanel.DrawingTarget target) {
            this.scale = scale;
            this.target = target;
        }
    }
}
