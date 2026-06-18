package dev.kalarianathecila.schoolStuff.ourFirstProgram;

import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int a;
        int b;
        int sum;
        int product;
        int difference;

        System.out.println("-------------------------------");
        System.out.println("💵        Money Calculator        💵");

        System.out.println("Input A: ");
        a = scn.nextInt();
        System.out.println("Input B: ");
        b = scn.nextInt();

        sum = a + b;
        product = a * b;
        difference = a - b;

        System.out.println("+-------------+");
        System.out.println("| Result: " + sum + " |          {----- Sum");
        System.out.println("| Result: " + product + " |          {----- Product");
        System.out.println("| Result: " + difference + " |          {----- Difference");
        System.out.println("+-------------+");
        System.out.println("Nvm just get rich");

    }

}
