package dev.kalarianathecila.schoolStuff.circleCalculator;

import java.util.Scanner;

public class TestCalculator {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int radius;
        // Set radius from user input
        System.out.println("Radius:");
        radius = scn.nextInt();
        // Create Calculator object and show all properties
        Calculator circle = new Calculator();
        circle.setRadius(23);
        circle.showAllProperties();
    }
}
