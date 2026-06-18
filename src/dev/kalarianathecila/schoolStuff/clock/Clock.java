package dev.kalarianathecila.schoolStuff.clock;

import java.util.Scanner;

public class Clock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a starting time below.");
        System.out.print("Enter the hours: ");
        int hours = scanner.nextInt();
        System.out.print("Enter the minutes: ");
        int minutes = scanner.nextInt();
        System.out.print("Enter the seconds: ");
        int seconds = scanner.nextInt();

        System.out.println("\nPlease enter a stopping time below.");
        System.out.print("Enter the hours: ");
        int hoursStop = scanner.nextInt();
        System.out.print("Enter the minutes: ");
        int minutesStop = scanner.nextInt();
        System.out.print("Enter the seconds: ");
        int secondsStop = scanner.nextInt();
        scanner.close();

        ClockBackend clock = new ClockBackend(hours, minutes, seconds, hoursStop, minutesStop, secondsStop);
        clock.run();
    }
}
