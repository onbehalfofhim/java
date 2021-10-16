package org.example;

import java.util.Scanner;

public class StaticArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите размер массива: ");

        int size = input.nextInt();
        int[] arr = new int[size];
        int sum = 0;

        if (5 <= size && size <= 20) {
            System.out.println("Введите " + size + " элементов:");
        } else {
            int digit = size % 10;
            if (digit == 1)
                System.out.println("Введите " + size + " элемент:");
            else if (2 <= digit && digit <= 4)
                System.out.println("Введите " + size + " элемента:");
            else
                System.out.println("Введите " + size + " элементов:");
        }

        for (int i = 0; i < size; ++i) {
            arr[i] = input.nextInt();
            sum += arr[i];
        }

        System.out.println("Сумма элементов статического массива = " + sum);
    }
}
