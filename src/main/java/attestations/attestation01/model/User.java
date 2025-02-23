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






    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }

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


}