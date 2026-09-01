package dev.kalarianathecila.schoolStuff.throwCalculator.visual;

import javax.swing.*;

public class CalculatorFrame  extends JFrame {
    public static void main(String[] args) {
        CalculatorFrame app = new CalculatorFrame();

        CalculatorPanel somePanel = new CalculatorPanel();
        app.add(somePanel);

        app.setVisible(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(1920, 1080);
    }
}
