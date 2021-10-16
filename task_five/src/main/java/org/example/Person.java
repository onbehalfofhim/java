package org.example;

public class Person {
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final int age;

    public Person(String lastName, String firstName, String middleName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.age = age;
    }

    @Override
    public String toString() {
        return lastName + ' ' + firstName + ' ' +  middleName + " - " + age;
    }
}
