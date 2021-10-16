package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\\n");

        List<Student> studentList = new ArrayList<>();

        System.out.print("Введите количество студентов в группе: ");
        int amount = input.nextInt();

        for (int k = 0; k < amount; ++k) {
            System.out.print("Введите фамилию " + (k + 1) + "-го студента: ");
            String lastName = input.next();
            System.out.print("Введите имя " + (k + 1) + "-го студента: ");
            String firstName = input.next();
            System.out.print("Введите отчество " + (k + 1) + "-го студента: ");
            String middleName = input.next();

            studentList.add(new Student(lastName, firstName, middleName));

            System.out.print("Введите оценки студента через пробел: ");
            String marks = input.next();
            String[] tokens = marks.split(" ");
            for (var t : tokens) {
                studentList.get(k).addMark(Integer.parseInt(t));
            }
        }

        /* studentList.sort(((first, second)->
                Double.compare(0.01, Math.abs(first.getMeanOfMarks() - second.getMeanOfMarks())))); */

        studentList.sort(Comparator.comparingDouble(Student::getMeanOfMarks).reversed());

        for (var student : studentList)
            System.out.println(student);

    }
}


/*((first, second)->
                Math.abs(first.getMeanOfMarks() - second.getMeanOfMarks()) < 0.01 ? 1 :
                        Math.abs(first.getMeanOfMarks() - second.getMeanOfMarks()) > 0.01 ? -1 : 0)*/