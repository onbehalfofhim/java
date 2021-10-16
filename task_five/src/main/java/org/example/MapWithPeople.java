package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapWithPeople {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Person> people = new HashMap<>();

        System.out.println("Enter names and age of people, end with \"exit\":");
        String lastName = input.nextLine();
        String firstName = input.nextLine();
        String middleName = input.nextLine();
        int age = input.nextInt();

        while(true){
            input.nextLine();

            people.put(lastName, new Person(lastName, firstName, middleName, age));

            lastName = input.nextLine();
            if (lastName.equals("exit")){
                break;
            }
            firstName = input.nextLine();
            middleName = input.nextLine();
            age = input.nextInt();
        }

        System.out.println("Enter the last name of person you want to find:");
        lastName = input.nextLine();

        if(people.get(lastName) != null){
            System.out.println(people.get(lastName));
        } else{
            System.out.println("There is no such person here");
        }
    }
}
