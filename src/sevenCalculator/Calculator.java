package sevenCalculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int number;
        int maxNumber = 9999;
        int maxInputNumber;

        void readUpperLimit() {
            System.out.println("Enter the upper limit (max " + maxNumber + "):");
            maxInputNumber = scn.nextInt();
            if (maxInputNumber > maxNumber) {
                System.out.println("This input is not correct. Please try again.");
                maxInputNumber = scn.nextInt();
            }
        }

        void outputSeven(){
            boolean seven;
            int number = 1;
            int numberLeft;

            for (int i = 0; i <= maxInputNumber; i++) {
                int result = calculateSeven(i);
                System.out.println("Input: " + i + " -> Result: " + result);
            }
        }
    }

    int calculateSeven(int number) {
        return number + 7;
    }
}
