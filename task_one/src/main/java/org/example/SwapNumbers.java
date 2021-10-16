package org.example;

import java.util.Scanner;

public class SwapNumbers {
    static void firstSolution(int first, int second){
        int one = first;
        int two = second;
        int temp = two;
        two = one;
        one = temp;

        System.out.println(one + ", " + two);
    }

    static void secondSolution(int first, int second){
        int one = first;
        int two = second;

        one += two;
        two = one - two;
        one -= two;

        System.out.println(one + ", " + two);
    }

    static void thirdSolution(int first, int second){
        int one = first;
        int two = second;

        one ^= two;
        two = one^two;
        one ^= two;

        System.out.println(one + ", " + two);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the first number: ");
        int first = scanner.nextInt();
        System.out.print("Input the second number: ");
        int second = scanner.nextInt();

        System.out.println("First solution:");
        firstSolution(first, second);

        System.out.println("Second solution:");
        secondSolution(first, second);

        System.out.println("Third solution:");
        thirdSolution(first, second);
    }
}
