package dev.kalarianathecila.schoolStuff.circleCalculator.dateManager;

import java.util.Scanner;

public class TestManager {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int day;
        int month;
        int year;

        Manager dateManager = new Manager();

        // Set date values
        dateManager.readDate();

        // Or use test date
        // dev.kalarianathecila.schoolStuff.circleCalculator.dateManager.setTestDate();

        // Show date formats and components
        dateManager.showClassicDateFormat();
        dateManager.showInternationalDateFormat();
        dateManager.showDay();
        dateManager.showMonth();
        dateManager.showYear();
        dateManager.showWeekday();
        dateManager.showMonthNameCase();
    }
}
