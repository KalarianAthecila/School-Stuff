package dev.kalarianathecila.schoolStuff.crossSumCalculator;

import java.util.Scanner;

public class TestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Set integer from user input
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        //Create Calculator object and calculate cross sum
        Calculator calculator = new Calculator();
        calculator.setInteger(number);
        int crossSum = calculator.calculateCrossSum();
        //Display the result
        System.out.println("The cross sum of " + number + " is: " + crossSum);
        scanner.close();
    }
}
