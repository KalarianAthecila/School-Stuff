package throwCalculator;

import java.util.Scanner;

public class Calculator {
    Scanner scn = new Scanner(System.in);
    // Math.toRadians();
    // Math.toDegrees();

    double throwHeight;
    double throwAngle;
    double throwSpeed;
    double v0;
    double x;
    double y;
    double xMovement;
    double yMovement;
    double time;
    double gravity = 9.81f;
    double alpha;

    public void inputData(){
        throwHeight = scn.nextDouble(); // Default: 10 meters
        throwAngle = scn.nextDouble(); // Default: 45 degrees
        v0 = scn.nextDouble(); // Default: 12 m/s
    }

    public void showThrowingData(){
        while (x > 0){
            // calculate x
            xMovement = v0 * Math.cos(alpha) * time;
            // calculate y
            yMovement = v0 * Math.sin(alpha) * time - gravity / 2 * Math.pow(time, 2);
            // check if at max height
            // output x and y
            System.out.println("Time: " + time + "X: " + x + "y: " + y);
            // increase time
        // output time, max height and range
        }
    }
}
