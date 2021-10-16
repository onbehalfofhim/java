package org.example;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number, sum = 0;
        do {
            System.out.print("Input a number: ");
            number = scanner.nextInt();
        } while (number < 0);

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        System.out.println(sum);
    }
}
