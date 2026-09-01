package dev.kalarianathecila.schoolStuff.mathematics;

public class Calculate {
    public int factorial(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    };
    public int fibonacci(int number) {
        if (number <= 1) return number;

        int a = 0, b = 1;
        for (int i = 2; i <= number; i++) {
            int result = a + b;
            a = b;
            b = result;
        }
        return b;
    }
}
