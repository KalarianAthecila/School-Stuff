package dev.kalarianathecila.schoolStuff.tutelini;

import javax.swing.*;
import java.net.URL;
//import com.formdev.flatlaf.FlatDarkLaf;

public class Draw extends JFrame {
    public static void main(String[] args) {
        //FlatDarkLaf.setup();

        SwingUtilities.invokeLater(() -> {
            Draw app = new Draw();

            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            app.setSize(1920, 1080);

            URL iconUrl = Draw.class.getResource("/dev/kalarianathecila/schoolStuff/tutelini/tutel.png");
            if (iconUrl != null) {
                app.setIconImage(new ImageIcon(iconUrl).getImage());
            }

            app.add(new MainPanel());
            app.setVisible(true);
        });
    }
}
