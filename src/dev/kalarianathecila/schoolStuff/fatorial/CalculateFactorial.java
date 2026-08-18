package dev.kalarianathecila.schoolStuff.fatorial;

public class CalculateFactorial {
    public static void main(String[] args) {
        FactorialBackend calculateFactorial = new FactorialBackend();

        int number = calculateFactorial.calculateFactorial(5);
        System.out.println(number);
    }
}
