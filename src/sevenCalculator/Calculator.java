package sevenCalculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int number;
        int maxNumber = 9999;
        int maxInputNumber;
        boolean isSeven;
        int numberLeft;

        void readUpperLimit() {
            System.out.println("Enter the upper limit (max " + maxNumber + "):");
            maxInputNumber = scn.nextInt();
            if (maxInputNumber > maxNumber) {
                System.out.println("This input is not correct. Please try again.");
                maxInputNumber = scn.nextInt();
            }
        }

        void outputSeven(){
            while (number <= maxNumber) {
                isSeven = false;
                numberLeft = number;
                while (numberLeft > 0) {
                    if (numberLeft % 10 == 7) {
                        isSeven = true;
                    }
                    numberLeft = numberLeft / 10;
                }
            }
            if (isSeven) { // TODO: Replace with check if number is seven.
                isSeven = true;
            }
            if (isSeven) {
                System.out.println(number);
                System.out.println("This is a seven.");
            }
            else {
                System.out.println(number);
                System.out.println("This is not a seven.");
            }
        }
    }
}
