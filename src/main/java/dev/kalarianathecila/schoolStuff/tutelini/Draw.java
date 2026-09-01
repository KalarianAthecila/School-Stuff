package dev.kalarianathecila.schoolStuff.tutelini;

import javax.swing.*;
import java.net.URL;
import com.formdev.flatlaf.FlatDarkLaf;

public class Draw extends JFrame {
    public static void main(String[] args) {
        FlatDarkLaf.setup();
        int scale = readScale(args);

        SwingUtilities.invokeLater(() -> {
            Draw app = new Draw();

            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            app.setSize(1920, 1080);

            URL iconUrl = Draw.class.getResource("/dev/kalarianathecila/schoolStuff/tutelini/tutel.png");
            if (iconUrl != null) {
                app.setIconImage(new ImageIcon(iconUrl).getImage());
            }

            app.add(new MainPanel(scale));
            app.setVisible(true);
        });
    }

    private static int readScale(String[] args) {
        if (args != null && args.length > 0) {
            Integer fromArg = parseScale(args[0]);
            if (fromArg != null) {
                return fromArg;
            }
        }

        String input = JOptionPane.showInputDialog(
                null,
                "Enter scale factor (positive integer):",
                "House Scale",
                JOptionPane.QUESTION_MESSAGE
        );

        Integer fromDialog = parseScale(input);
        return fromDialog != null ? fromDialog : 1;
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
}
