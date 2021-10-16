package org.example;

import java.util.Scanner;

public class Watch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int amount, k = 0;
        do {
            System.out.print("Input a number: ");
            amount = scanner.nextInt();
        } while (amount % 2 == 0);

        for (int i = -amount; i < amount + 1; i += 2) {
            if (i == 1) {
                k -= 2;
                continue;
            }
            for (int j = Math.abs(i); j > 0; --j) {
                System.out.print('*');
            }
            System.out.println();
            if (i < -1) {
                System.out.print(' ');
                k++;
            }

            if ((k >= 2) && (i <= -1)) {
                for (int m = 2; m < k + 1; ++m) {
                    System.out.print(' ');
                }
            }

            if (i > 1) {
                for (int n = k; n > 0; --n) {
                    System.out.print(' ');
                }
                k--;
            }
        }
    }
}
