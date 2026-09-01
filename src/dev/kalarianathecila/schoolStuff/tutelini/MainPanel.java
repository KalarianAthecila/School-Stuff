package dev.kalarianathecila.schoolStuff.tutelini;

import java.awt.*;

public class MainPanel extends Panel {
    private Turtle tutel = null;

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        this.tutel = new Turtle(this, g);
        draw();
        drawHouse();
    }

    public void draw() {
        tutel.homePosition();
        tutel.turnLeft(90);
        tutel.move(100);
    };

    public void drawHouse() {
        tutel.homePosition();
        tutel.move(100);
        tutel.turnLeft(90);
        tutel.move(100);
        tutel.turnLeft(137);
        tutel.move(137);
        tutel.turnRight(137);
        tutel.move(100);
        tutel.turnRight(45);
        tutel.move(67);
        tutel.turnRight(90);
        tutel.move(66);
        tutel.turnRight(135);
        tutel.move(94);
        tutel.turnLeft(133);
        tutel.move(150);
    }
}
