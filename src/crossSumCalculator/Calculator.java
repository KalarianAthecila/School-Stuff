package crossSumCalculator;

public class Calculator {

    private int number;

    void setInteger(int number) {
        // Set the integer value
        this.number = number;
    }

    int calculateCrossSum() {
        // Calculate the cross sum (sum of digits) of the integer
        int sum = 0;
        // Handle negative numbers by taking the absolute value
        int n = Math.abs(number);
        // Sum the digits with a loop
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
