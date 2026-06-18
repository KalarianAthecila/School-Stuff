package dev.kalarianathecila.schoolStuff.circleCalculator.formulaCalculator;

public class Calculator {

    public static void main(String[] args) {

        int number1 = -3;
        int number2 = 4;
        int number3 = 5;

        double result1 = (double)number1/number2;
        double result2 = Math.cbrt(number2);
        double result3 = Math.pow(number3,3);
        double result4 = Math.sqrt(Math.pow(number2,2)+Math.pow(number3,2));
        double result5 = (Math.sqrt(Math.pow(number2,2)+Math.pow(number3,2)))/(Math.abs(number1)+2);
        double result6 = Math.sin((3*number1*Math.PI)/number3);
        double result7 = ((number1*number2+Math.pow(number3,number1))/3)+(double)number2/(2+(5/(double)number2));

        System.out.print("Result 1: ");
        System.out.println(result1);
        System.out.print("Result 2: ");
        System.out.println(result2);
        System.out.print("Result 3: ");
        System.out.println(result3);
        System.out.print("Result 4: ");
        System.out.println(result4);
        System.out.print("Result 5: ");
        System.out.println(result5);
        System.out.print("Result 6: ");
        System.out.println(result6);
        System.out.print("Result 7: ");
        System.out.println(result7);
    }

}
