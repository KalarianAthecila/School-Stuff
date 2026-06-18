package dev.kalarianathecila.schoolStuff.throwCalculator.cli;

import java.util.Scanner;

public class Calculator {
    Scanner scn = new Scanner(System.in);
    // Math.toRadians();
    // Math.toDegrees();

    double throwHeight; // This is the height from which the throw is made. It can also be 0 if the throw is made from the ground.
    double throwAngle; // This is the angle of the throw.
    double throwSpeed; // This is the initial speed of the throw
    double x; // This is the distance of the throw on the x axis at a given time.
    double y; // This is the height of the hrow at a given time.
    double xMovement; // This is the movement of the throw on the x axis.
    double yMovement; // This is the movement of the throw on the y axis.
    double time; // This is the time that has passed since the throw, in seconds. It starts at 0 and increases by 1 every loop until the throw is finished.
    double gravity = 9.81f; // This is earth gravity, rounded to a general value that roughly applies everywhere one arth.
    double alpha; // NOT "alfa", that's not correct language lol.

    public void inputData(){
        System.out.println("Input throw height, throw angle and throw speed:");
        System.out.println("-----------------------------------");
        System.out.println("Input throw height:");
        throwHeight = scn.nextDouble(); // Default: 10 meters
        System.out.println("Input throw angle:");
        throwAngle = scn.nextDouble(); // Default: 45 degrees
        System.out.println("Input throw speed:");
        throwSpeed = scn.nextDouble(); // Default: 12 m/s
    }

    public void showThrowingData(){
        while (x > 0.1){
            // calculate x
            xMovement = throwSpeed * Math.cos(alpha) * time;
            // calculate y
            yMovement =throwSpeed * Math.sin(alpha) * time - gravity / 2 * Math.pow(time, 2);
            // check if at max height
            // output x and y
            System.out.println("Time: " + time + "X: " + x + "y: " + y);
            // increase time
            time += 1;
        // output time, max height and range
        }
    }
}
