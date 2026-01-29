package repaymentScheduleCalculator;

import sevenCalculator.Calculator;

public class TestCalculator {
    public static void main(String[] args) {
        repaymentScheduleCalculator.Calculator repaymentScheduleCalculator = new Calculator();
        repaymentScheduleCalculator.inputData();
        repaymentScheduleCalculator.calculateData();
    }
}
