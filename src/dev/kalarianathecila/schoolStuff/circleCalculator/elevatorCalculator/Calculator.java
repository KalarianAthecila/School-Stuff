package dev.kalarianathecila.schoolStuff.circleCalculator.elevatorCalculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        double pi = Math.PI;

        int motorRPM;
        double pulleyDiameter;
        int runtimeMinutes;

        System.out.println("Motor revolutions per minute: ");
        motorRPM = scn.nextInt();
        System.out.println("Diameter of the cable pulley (e.g. 1.4 or 1,4): ");
        String diameterInput = scn.next();
        diameterInput = diameterInput.replace(',', '.');
        pulleyDiameter = Double.parseDouble(diameterInput);
        System.out.println("Runtime in minutes: ");
        runtimeMinutes = scn.nextInt();

        double speed = (motorRPM * pi * pulleyDiameter) / 60;
        double distance = speed * runtimeMinutes * 60;

        System.out.print("Speed: ");
        System.out.print(speed);
        System.out.println(" m/s");

        System.out.print("Distance: ");
        System.out.print(distance);
        System.out.print(" m");
    }

}
