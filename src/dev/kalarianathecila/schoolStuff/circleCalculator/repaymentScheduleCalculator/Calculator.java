package dev.kalarianathecila.schoolStuff.circleCalculator.repaymentScheduleCalculator;

import java.util.Scanner;

public class Calculator {
    double loanAmount;
    double interestRate;
    double monthlyInstallment;

    /*
    EXAMPLE INPUT AND OUTPUT:

    Please enter your credit details:
    Loan amount (Euro): 10,000
    Interest rate: 10%
    Monthly installment (Euro): 1,000

    Output:
    Loan amount: 10,000 Euro
    Monthly installment amount: 1,000 Euro
    Interest rate in percent: 10%

    Repayment schedule
    ------------------------------------------------------
    Month  Remaining loan  Monthly rate  Repayment  Interest
    ------------------------------------------------------
    1      10000.00        1000.00       916.67     83.33
    2      9083.33         1000.00       924.31     75.69
    3      8159.03         1000.00       932.01     67.99
    4      7227.02         1000.00       939.77     60.23
    5      6287.24         1000.00       947.61     52.39
    6      5339.64         1000.00       955.50     44.50
    7      4384.13         1000.00       963.47     36.53
    8      3420.67         1000.00       971.49     28.51
    9      2449.17         1000.00       979.59     20.41
    10     1469.58         1000.00       987.75     12.25
    11     481.83          485.85        481.83     4.02

    The loan term was 11 months
    Total interest: 485.85 Euro
    */
    void inputData() {
        // Input all the necessary data.
        Scanner scn = new Scanner(System.in);
        System.out.println("Please enter your credit details:");
        System.out.print("Loan amount (Euro): ");
        loanAmount = scn.nextDouble();
        System.out.print("Interest rate (%): ");
        interestRate = scn.nextDouble();
        System.out.print("Monthly installment (Euro): ");
        monthlyInstallment = scn.nextDouble();
    }

    void calculateData() {
        // Begin to output the table.
        System.out.println();
        System.out.printf("Loan amount: %.2f Euro%n", loanAmount);
        System.out.printf("Monthly installment amount: %.2f Euro%n", monthlyInstallment);
        System.out.printf("Interest rate in percent: %.2f%%%n", interestRate);
        System.out.println();
        System.out.println("Repayment schedule");
        System.out.println("------------------------------------------------------");
        System.out.println("Month  Remaining loan  Monthly rate  Repayment  Interest");
        System.out.println("------------------------------------------------------");

        // Calculate the remaining values.
        double remainingLoan = loanAmount;
        double totalInterest = 0.0;
        int month = 1;

        while (remainingLoan > 0.01) {
            double interest = remainingLoan * (interestRate / 100) / 12;
            double repayment = Math.min(monthlyInstallment - interest, remainingLoan);
            double monthlyRate = repayment + interest;
            if (repayment < 0) repayment = 0;
            if (monthlyRate > remainingLoan + interest) monthlyRate = remainingLoan + interest;

            // We printin'
            System.out.printf("%-6d %-15.2f %-13.2f %-10.2f %.2f%n",
                    month, remainingLoan, monthlyRate, repayment, interest);

            remainingLoan -= repayment;
            totalInterest += interest;
            month++;

            if (remainingLoan < 0.01) {
                break;
            }
            // If the last payment is less than the monthly installment, adjust for the last month
            if (remainingLoan + interest < monthlyInstallment) {
                monthlyInstallment = remainingLoan + interest;
            }
        }

        // Output the remaining values into the table.
        System.out.println();
        System.out.printf("The loan term was %d months%n", month - 1);
        System.out.printf("Total interest: %.2f Euro%n", totalInterest);
    }
}
