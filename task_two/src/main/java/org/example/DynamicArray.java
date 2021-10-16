package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();

        System.out.println("Введите элементы массива, завершите ввод символом '0':");

        int elem = input.nextInt();
        while (elem != 0){
            arr.add(elem);
            elem = input.nextInt();
        }

        System.out.println("Введите элемент, индекс которого хотите узнать: ");
        int fav = input.nextInt();

        int index = arr.indexOf(fav);

        if(index < 0)
            System.out.println("Элемент не найден :(");
        else
            System.out.println("индекс искомого элемента = " + index);
    }
}
