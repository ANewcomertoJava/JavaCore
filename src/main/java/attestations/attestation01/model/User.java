package attestations.attestation01.model;

import attestations.attestation01.exceptions.InvalidDataException;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.regex.Pattern;

public class User {
    private String id;
    private LocalDateTime registrationDate;
    private String login;
    private String password;
    private String confirmPassword;
    private String lastName;
    private String firstName;
    private String middleName;
    private Integer age;
    private boolean isWorker;

    public User(String id, LocalDateTime registrationDate, String login, String password, String confirmPassword,
                String lastName, String firstName, String middleName, Integer age, boolean isWorker) {
        validateLogin(login);
        validatePassword(password, confirmPassword);
        validateName(lastName, "Фамилия");
        validateName(firstName, "Имя");
        if (middleName != null) validateName(middleName, "Отчество");
        if (age != null && age < 0) throw new InvalidDataException("Возраст не может быть отрицательным");

        this.id = id;
        this.registrationDate = registrationDate;
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.age = age;
        this.isWorker = isWorker;
    }

    public User(String line) {
        String[] parts = line.split("\\|");
        this.id = parts[0];
        this.registrationDate = LocalDateTime.parse(parts[1]);
        this.login = parts[2];
        this.password = parts[3];
        this.confirmPassword = parts[4];
        this.lastName = parts[5];
        this.firstName = parts[6];
        this.middleName = parts[7];
        this.age = Integer.parseInt(parts[8]);
        this.isWorker = Boolean.parseBoolean(parts[9]);
    }

    private void validateLogin(String login) {
        if (login == null || login.length() >= 20 || !Pattern.matches("[a-zA-Z0-9_]+", login)) {
            throw new InvalidDataException("Логин должен содержать только буквы, цифры и знак подчеркивания, и быть меньше 20 символов");
        }
    }

    private void validatePassword(String password, String confirmPassword) {
        if (password == null || !password.equals(confirmPassword)) {
            throw new InvalidDataException("Пароль и подтверждение пароля не совпадают");
        }
        if (password.length() >= 20 || !Pattern.matches("[a-zA-Z0-9_]+", password)) {
            throw new InvalidDataException("Пароль должен содержать только буквы, цифры и знак подчеркивания, и быть меньше 20 символов");
        }
    }

    private void validateName(String name, String fieldName) {
        if (name == null || !Pattern.matches("[a-zA-Zа-яА-Я]+", name)) {
            throw new InvalidDataException(fieldName + " должна состоять только из букв");
        }
    }

// Геттеры и сеттеры остаются без изменений
// ...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + "|" + registrationDate + "|" + login + "|" + password + "|" + confirmPassword + "|" +
                lastName + "|" + firstName + "|" + middleName + "|" + age + "|" + isWorker;
    }

    public String getId() {
        return id;
    }

    public void setAge(Integer age) {
        if (age == null) {
            throw new InvalidDataException("Возраст не может быть null");
        }
        if (age < 0) {
            throw new InvalidDataException("Возраст не может быть отрицательным");
        }
        this.age = age;
    }
}