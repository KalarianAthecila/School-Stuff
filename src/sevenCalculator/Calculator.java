package sevenCalculator;

import java.util.Scanner;

public class Calculator {
    Scanner scn = new Scanner(System.in);

    int maxNumber = 9999;
    int maxInputNumber;

    void readUpperLimit() {
        while (true) {
            System.out.println("Enter the upper limit (max " + maxNumber + "):");
            if (scn.hasNextInt()) {
                maxInputNumber = scn.nextInt();
                if (maxInputNumber > 0 && maxInputNumber <= maxNumber) {
                    break;
                } else {
                    System.out.println("This input is not correct. Please try again.");
                }
            } else {
                System.out.println("Please enter a valid integer.");
                scn.next(); // consume invalid input
            }
        }
    }

    void outputSeven() {
        StringBuilder sevens = new StringBuilder();
        for (int i = 1; i <= maxInputNumber; i++) {
            int numberRemaining = i;
            while (numberRemaining > 0) {
                if (numberRemaining % 10 == 7) {
                    if (!sevens.isEmpty()) sevens.append(", ");
                    sevens.append(i);
                    break;
                }
                numberRemaining = numberRemaining / 10;
            }
        }
        if (!sevens.isEmpty()) {
            System.out.println("Numbers containing a 7: " + sevens);
        } else {
            System.out.println("No numbers contain a 7.");
        }
    }
}
