package org.example;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final List<Integer> marks = new ArrayList<>();

    public Student(String lastName,  String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public List<Integer> getMarks() {
        return this.marks;
    }

    public void addMark(int mark){
        marks.add(mark);
    }

    public double getMeanOfMarks(){
        Integer sum = 0;
        if(!marks.isEmpty()) {
            for (var mark : marks) {
                sum += mark;
            }
            return sum.doubleValue() / marks.size();
        }
        return sum;
    }

    @Override
    public String toString() {
        return lastName + ' ' + firstName + ' ' +  middleName + ": " + getMeanOfMarks();
    }
}
