package dev.kalarianathecila.schoolStuff.circleCalculator;

public class Calculator {
    int radius;
    double pi = Math.PI;

    void showRadius(){
        // Display the radius
        System.out.println("Radius: " + getRadius());
    }

    void setRadius(int r){
        // Set the radius
        radius = r;
    }

    int getRadius() {
        // Get the radius
        return radius;
    }

    void showArea(){
        // Calculate and display the area
        double area = pi * getRadius() * getRadius();
        System.out.println("Area: " + area);
    }

    void showCircumference(){
        // Calculate and display the circumference
        double circumference = 2 * pi * getRadius();
        System.out.println("Circumference: " + circumference);
    }

    void showDiameter(){
        // Calculate and display the diameter
        int diameter = 2 * getRadius();
        System.out.println("Diameter: " + diameter);
    }

    void showAllProperties(){
        // Show all properties of the circle
        showRadius();
        showArea();
        showCircumference();
        showDiameter();
    }
}
