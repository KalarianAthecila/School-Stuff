package dev.kalarianathecila.schoolStuff.tutelini;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import com.formdev.flatlaf.FlatDarkLaf;

public class Draw extends JFrame {
    public static void main(String[] args) {
        FlatDarkLaf.setup();
        DrawSelection selection = readSelection(args);

        SwingUtilities.invokeLater(() -> {
            Draw app = new Draw();

            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            app.setSize(1920, 1080);

            URL iconUrl = Draw.class.getResource("/dev/kalarianathecila/schoolStuff/tutelini/tutel.png");
            if (iconUrl != null) {
                app.setIconImage(new ImageIcon(iconUrl).getImage());
            }

            app.add(new MainPanel(selection.scale, selection.target));
            app.setVisible(true);
        });
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
        JCheckBox houseCheck = new JCheckBox("Use scale for house", argTarget == MainPanel.DrawingTarget.HOUSE);
        JCheckBox treeCheck = new JCheckBox("Use scale for tree", argTarget == MainPanel.DrawingTarget.TREE);

        ButtonGroup group = new ButtonGroup();
        group.add(houseCheck);
        group.add(treeCheck);

        JPanel panel = new JPanel(new GridLayout(0, 1, 0, 6));
        panel.add(new JLabel("Enter scale factor (positive integer):"));
        panel.add(scaleField);
        panel.add(new JLabel("Apply scale to:"));
        panel.add(houseCheck);
        panel.add(treeCheck);

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
                        "Please enter a positive integer for scale.",
                        "Invalid Scale",
                        JOptionPane.WARNING_MESSAGE
                );
                continue;
            }

            MainPanel.DrawingTarget target = treeCheck.isSelected()
                    ? MainPanel.DrawingTarget.TREE
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
