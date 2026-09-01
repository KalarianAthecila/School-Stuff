package dev.kalarianathecila.schoolStuff.mathematics;

public class CalculateStuff {
    public static void main(String[] args) {
        Calculate calculateFactorial = new Calculate();

        System.out.println("\n");
        System.out.println("---------- MATHEMATICS -----------");
        System.out.println("This program calculates stuff. Yep, that's it, deal with it.");
        System.out.println("If you want to output other numbers without changing the code, yo can't. Also deal with that I guess.");
        System.out.println("\n");

        int factorial = calculateFactorial.factorial(5);
        System.out.println("Factorial: " + factorial);
        long fibonacci = calculateFactorial.fibonacci(9);
        System.out.println("Fibonacci: " + fibonacci);
    }
}
