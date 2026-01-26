package sevenCalculator;

import java.util.Scanner;

public class TestCalculator {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int number;

        Calculator calculator = new Calculator();

        System.out.println("Enter a number:");
        number = scn.nextInt();

        int result = calculator.calculateSeven(number);
        System.out.println("Result: " + result);
    }
}
