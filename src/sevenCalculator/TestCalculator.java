package sevenCalculator;


import java.util.Scanner;

public class TestCalculator {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        Calculator sevenCalculator = new Calculator();

        sevenCalculator.readUpperLimit();
        sevenCalculator.outputSeven();

    }
}
