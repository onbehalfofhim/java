package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите день: ");
        int day = input.nextInt();
        System.out.print("Введите месяц: ");
        int month = input.nextInt();
        System.out.print("Введите год: ");
        int year = input.nextInt();
        System.out.print("Введите часы: ");
        int hour = input.nextInt();
        System.out.print("Введите минуты: ");
        int minutes = input.nextInt();
        System.out.print("Введите секунды: ");
        int seconds = input.nextInt();
        DateTime dateTime = new DateTime(year, month, day, hour, minutes, seconds);

        input.nextLine();

        System.out.println("Вы установили дату и время: " + dateTime);

//        System.out.println("Введите количество секунд, на которой хотите сдвинуть время: ");
//        int shiftSec = input.nextInt();
//
//        dateTime.shiftSeconds(shiftSec);
//        System.out.println("Вы установили дату и время: " + dateTime);

        System.out.println("Введите количество дней, на которой хотите сдвинуть дату: ");
        int shiftDay = input.nextInt();

        dateTime.shiftDays(shiftDay);
        System.out.println("Вы установили дату и время: " + dateTime);
    }
}
