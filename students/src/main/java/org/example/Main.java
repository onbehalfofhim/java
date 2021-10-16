package org.example;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Student> students = new ArrayList<>();
    public static Scanner input = new Scanner(System.in);
    public static File file = new File("students.bin");

    public static void main(String[] args) {
        load();
        int menuItem = showMenu();

        while (menuItem != 7) {
            switch (menuItem) {
                case 1:
                    printExtendedList(students);
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    printShortList();
                    editStudent();
                    break;
                case 4:
                    printShortList();
                    deleteStudent();
                    break;
                case 5:
                    showExcellent();
                    break;
                case 6:
                    showNotExcellent();
                    break;
                default:
                    break;
            }
            menuItem = showMenu();
        }
        save();
    }

    public static int showMenu() {
        System.out.print("\n1. Список студентов \n" +
                "2. Добавить студента \n" +
                "3. изменить студента \n" +
                "4. Удалить студента \n" +
                "5. Показать отличников \n" +
                "6. Показать неуспевающих \n" +
                "7. Выход \n" +
                ">");
        int menuItem = input.nextInt();
        input.nextLine();
        return menuItem;
    }

    public static int showSubmenu() {
        System.out.print("\n1. изменить фамилию \n" +
                "2. изменить имя \n" +
                "3. изменить отчество \n" +
                "4. изменить группу \n" +
                "5. Добавить оценку \n" +
                "6. изменить оценку\n" +
                "7. Удалить оценку \n" +
                "8. Выход \n" +
                ">");
        int item = input.nextInt();
        input.nextLine();
        return item;
    }

    public static void printShortList() {
        if (students.isEmpty()) {
            System.out.println("Студентов нет");
        } else {
            int i = 1;
            for (var student : students) {
                System.out.println(i + ". " + student.getShortForm());
                ++i;
            }
        }
    }

    public static void printExtendedList(List<Student> studentList) {
        if (studentList.isEmpty()) {
            System.out.println("Студентов нет");
        } else {
            int i = 1;
            for (var student : studentList) {
                System.out.println("=== " + i + " ===\n" + student.getExtendedForm());
                ++i;
            }
        }
    }

    public static void addStudent() {
        System.out.print("Введите фамилию: ");
        String lastName = input.nextLine();
        System.out.print("Введите имя: ");
        String firstName = input.nextLine();
        System.out.print("Введите отчество: ");
        String middleName = input.nextLine();
        System.out.print("Введите группу: ");
        String group = input.nextLine();
        students.add(new Student(lastName, firstName, middleName, group));
        save();
        printShortList();
    }

    public static void editStudent() {
        if (students.isEmpty()) return;

        System.out.print("Введите номер студента для редактирования: \n" + ">");
        int number = input.nextInt();
        input.nextLine();

        if (number < 1 || number > students.size()) {
            System.out.println("Вы ввели неверный номер студента");
            return;
        }
        --number;

        Student student = students.get(number);
        System.out.println("Редактируемый студент:\n" + student.getExtendedForm());

        int item = showSubmenu();

        while (item != 8) {
            switch (item) {
                case 1:
                    System.out.print("Новая фамилия: ");
                    String lastName = input.nextLine();
                    student.setLastName(lastName);
                    break;
                case 2:
                    System.out.print("Новое имя: ");
                    String firstName = input.nextLine();
                    student.setFirstName(firstName);
                    break;
                case 3:
                    System.out.print("Новое отчество: ");
                    String middleName = input.nextLine();
                    student.setMiddleName(middleName);
                    break;
                case 4:
                    System.out.print("Новая группа: ");
                    String group = input.nextLine();
                    student.setGroup(group);
                    break;
                case 5:
                    System.out.print("Предмет: ");
                    String sub = input.nextLine();
                    if (student.getMark(sub) != -1) {
                        System.out.println("У студента уже есть оценка по этому предмету");
                        break;
                    }
                    System.out.print("Оценка: ");
                    int mark = input.nextInt();
                    input.nextLine();
                    student.addMark(sub, mark);
                    break;
                case 6:
                    System.out.print("Предмет: ");
                    String s = input.nextLine();
                    if (student.getMark(s) == -1) {
                        System.out.println("У студента нет оценки по этому предмету");
                        break;
                    }
                    System.out.print("Оценка: ");
                    int m = input.nextInt();
                    input.nextLine();
                    student.addMark(s, m);
                    break;
                case 7:
                    System.out.print("Предмет: ");
                    String subject = input.nextLine();
                    if (student.getMark(subject) == -1) {
                        System.out.println("У студента нет оценки по этому предмету");
                        break;
                    }
                    System.out.print("Вы уверены, что хотите удалить оценку по " + subject + "? [y/N] ");
                    String answer = input.nextLine();
                    if (answer.equals("y")) {
                        student.deleteMark(subject);
                    }
                    break;
            }
            save();
            System.out.println("\nРедактируемый студент:\n" + student.getExtendedForm());
            item = showSubmenu();
        }
    }

    public static void deleteStudent() {
        if (students.isEmpty()) return;

        System.out.print("Номер студента для удаления: ");
        int number = input.nextInt();
        input.nextLine();

        if (number < 1 || number > students.size()) {
            System.out.println("Вы ввели неверный номер студента");
            return;
        }
        --number;

        System.out.print("Вы уверены, что хотите удалить студента " + students.get(number).getShortForm() +
                "? [y/N] ");
        String answer = input.nextLine();
        if (answer.equals("y")) {
            students.remove(number);
        }
        save();
        printShortList();
    }

    public static void showExcellent() {
        List<Student> excellent = new ArrayList<>();
        for (var student : students) {
            if (student.getMarksCount() > 0) {
                boolean allFive = true;
                for (var subject : student.getSubjects()) {
                    if (student.getMark(subject) != 5) {
                        allFive = false;
                        break;
                    }
                }
                if (allFive) excellent.add(student);
            }
        }
        printExtendedList(excellent);
    }

    public static void showNotExcellent() {
        List<Student> notExcellent = new ArrayList<>();
        for (var student : students) {
            if (student.getMarksCount() > 0) {
                boolean haveTwo = false;
                for (var subject : student.getSubjects()) {
                    if (student.getMark(subject) < 3) {
                        haveTwo = true;
                        break;
                    }
                }
                if (haveTwo) notExcellent.add(student);
            }
        }

        printExtendedList(notExcellent);
    }

    public static void save() {
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(file, false))) {
            ByteBuffer buffer = ByteBuffer.allocate(4 * 1024);
            buffer.putShort((short) students.size());
            for (int i = 0; i < students.size(); ++i) {
                Student student = students.get(i);

                byte[] lastName = student.getLastName().getBytes();
                byte[] firstName = student.getFirstName().getBytes();
                byte[] middleName = student.getMiddleName().getBytes();
                byte[] group = student.getGroup().getBytes();

                buffer.put((byte) lastName.length);
                buffer.put(lastName);
                buffer.put((byte) firstName.length);
                buffer.put(firstName);
                buffer.put((byte) middleName.length);
                buffer.put(middleName);
                buffer.put((byte) group.length);
                buffer.put(group);

                buffer.put(student.getMarksCount());
                for (var subject : student.getSubjects()) {
                    byte[] subName = subject.getBytes();
                    buffer.putShort((short) subName.length);
                    buffer.put(subName);
                    buffer.put((byte) student.getMark(subject));
                }
            }
            out.write(buffer.array());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load() {
        try (InputStream in = new BufferedInputStream(new FileInputStream(file))) {
            byte[] data = new byte[4 * 1024];

            int bytesRead = in.read(data);

            if (bytesRead != 0) {
                ByteBuffer buffer = ByteBuffer.wrap(data, 0, bytesRead);

                short studentCount = buffer.getShort();
                for (int i = 0; i < studentCount; ++i) {
                    byte size = buffer.get();
                    byte[] last = new byte[size];
                    buffer.get(last);
                    String lastName = new String(last);

                    size = buffer.get();
                    byte[] first = new byte[size];
                    buffer.get(first);
                    String firstName = new String(first);

                    size = buffer.get();
                    byte[] middle = new byte[size];
                    buffer.get(middle);
                    String middleName = new String(middle);

                    size = buffer.get();
                    byte[] gr = new byte[size];
                    buffer.get(gr);
                    String group = new String(gr);

                    students.add(new Student(lastName, firstName, middleName, group));

                    byte marksCount = buffer.get();
                    for (int j = 0; j < marksCount; ++j) {
                        short sizeSub = buffer.getShort();
                        byte[] subName = new byte[sizeSub];
                        buffer.get(subName);
                        String subject = new String(subName);
                        byte mark = buffer.get();
                        students.get(i).addMark(subject, mark);
                    }
                }
            }
        } catch (FileNotFoundException fne) {
            System.out.println("Файла со студентами еще нет");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
