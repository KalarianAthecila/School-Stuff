package sevenCalculator;


import java.util.Scanner;

public class TestCalculator {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int number;
        int maxNumber = 9999;
        int maxInputNumber;
        boolean isSeven;
        int numberLeft;

        Calculator sevenCalculator = new Calculator();

        sevenCalculator.readUpperLimit();
        sevenCalculator.outputSeven();

    }
}
