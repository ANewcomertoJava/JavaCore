package homeworks.homework12;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private long phoneNumber;
    private char gender;
    private int age;

    public Person(String lastName, String firstName, String middleName, LocalDate birthDate, long phoneNumber, char gender, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
    }

    // Геттеры
    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName + " " + birthDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " " + phoneNumber + " " + gender + " " + age;
    }
}