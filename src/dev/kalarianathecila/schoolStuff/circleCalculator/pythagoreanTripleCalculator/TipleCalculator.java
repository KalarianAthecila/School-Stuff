package dev.kalarianathecila.schoolStuff.circleCalculator.pythagoreanTripleCalculator;

import java.util.Scanner;

public class TipleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int max = scanner.nextInt();
        scanner.close();

        CalculateTriples calc = new CalculateTriples(max);
        calc.calculate();
        calc.printTriples();
    }
}
