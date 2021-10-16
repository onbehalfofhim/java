package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int hideNumber = random.nextInt(100 - 1 + 1) + 1;
        int number = 0;
        int attempt = 0;

        System.out.println("Enter your name:");
        String name = input.nextLine();

        while (number != hideNumber) {
            System.out.println("Enter your number:");
            number = input.nextInt();
            ++attempt;

            if (hideNumber > number) {
                System.out.println("My number is greater. Try again :)");
            } else {
                System.out.println("My number is less. Try again :)");
            }
        }

        System.out.println("You guessed the number in " + attempt + " tries!");
        updateGamersList(name, attempt);
    }

    public static void updateGamersList(String name, int attempt) {
        Map<String, Integer> gamers = new HashMap<>();

        File file = new File("listOfGamers.txt");
        try (Scanner in = new Scanner(file)) {
            while (in.hasNextLine()) {
                String data = in.nextLine();
                int index = data.indexOf(' ');
                gamers.put(data.substring(0, index),
                        Integer.parseInt(data.substring(index + 1)));
            }
        } catch (FileNotFoundException e) {
            //отсутвующий файл - это нормально
        } catch (NumberFormatException nfe) {
            System.out.println("File is broken");
            gamers.clear();
        }
        if (!gamers.containsKey(name) || gamers.get(name) > attempt) {
            gamers.put(name, attempt);
        }
        try (Writer out = new BufferedWriter(new FileWriter(file, false))) {
            for (Map.Entry<String, Integer> entry : gamers.entrySet()) {
                out.write(entry.getKey() + " " + entry.getValue() + "\n");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}