package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Student {
    private String lastName;
    private String firstName;
    private String middleName;
    private String group;
    private final Map<String, Integer> marks = new HashMap<>();

    public Student(String lastName, String firstName, String middleName, String group) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.group = group;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getGroup() {
        return group;
    }

    public int getMark(String subject) {
        return marks.get(subject) == null ? -1 : marks.get(subject);
    }

    public Set<String> getSubjects() {
        return marks.keySet();
    }

    public byte getMarksCount() {
        return (byte) marks.size();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void addMark(String subject, int mark) {
        marks.put(subject, mark);
    }

    public int deleteMark(String subject) {
        return marks.remove(subject);
    }

    public String getShortForm() {
        return lastName + ' ' + firstName + ' ' + middleName + " (" + group + ")";
    }

    public String getExtendedForm() {
        return "Фамилия: " + lastName + '\n' +
                "имя: " + firstName + '\n' +
                "Отчество: " + middleName + '\n' +
                "Группа: " + group + '\n' +
                "Оценки: \n" + getListOfMarks();

    }

    public String getListOfMarks() {
        StringBuilder result = new StringBuilder();
        Set<String> subjects = getSubjects();
        if (subjects.isEmpty()) {
            result.append(" Оценок нет");
        } else {
            for (var sub : subjects) {
                result.append(' ').append(sub).append(": ").append(getMark(sub)).append('\n');
            }
        }
        return result.toString();
    }
}
