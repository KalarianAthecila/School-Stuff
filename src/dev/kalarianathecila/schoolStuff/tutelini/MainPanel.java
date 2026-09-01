package dev.kalarianathecila.schoolStuff.tutelini;

import java.awt.*;

public class MainPanel extends Panel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(10, 10, 100, 100);

        Turtle tutel = new Turtle(this, g);
        tutel.homePosition();
        tutel.move(100);
    }
}
