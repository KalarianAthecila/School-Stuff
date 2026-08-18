package dev.kalarianathecila.schoolStuff.fatorial;

public class FactorialBackend {
    public int calculateFactorial(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
