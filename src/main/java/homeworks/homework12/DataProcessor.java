package homeworks.homework12;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DataProcessor {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public void processData() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные: Фамилия Имя Отчество дата рождения в формате ДД.ММ.ГГГ номертелефона без пробелов пол(f/m) возраст");

        try {
            String input = scanner.nextLine();
            String[] data = input.split(" ");

            validateInput(data); // Проверка количества полей

            Person person = parseInput(data); // Парсинг данных

            writeToFile(person); // Запись в файл
            System.out.println("Данные успешно записаны в файл.");

        } catch (InvalidDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private void validateInput(String[] data) throws InvalidDataException {
        if (data.length != 7) {
            throw new InvalidDataException("Неверное количество данных. Ожидается 7 полей.");
        }
    }

    private Person parseInput(String[] data) throws InvalidDataException {
        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        LocalDate birthDate = parseDate(data[3]);
        long phoneNumber = parsePhoneNumber(data[4]);
        char gender = parseGender(data[5]);
        int age = parseAge(data[6]);

        return new Person(lastName, firstName, middleName, birthDate, phoneNumber, gender, age);
    }

    private LocalDate parseDate(String dateStr) throws InvalidDataException {
        try {
            return LocalDate.parse(dateStr, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new InvalidDataException("Неверный формат даты. Ожидается формат ДД.ММ.ГГГГ.");
        }
    }

    private long parsePhoneNumber(String phoneStr) throws InvalidDataException {
        try {
            long phoneNumber = Long.parseLong(phoneStr);
            if (phoneNumber < 0) {
                throw new InvalidDataException("Номер телефона не может быть отрицательным.");
            }
            return phoneNumber;
        } catch (NumberFormatException e) {
            throw new InvalidDataException("Неверный формат номера телефона. Номер должен состоять только из цифр.");
        }
    }

    private char parseGender(String genderStr) throws InvalidDataException {
        if (genderStr.length() != 1 || (genderStr.charAt(0) != 'f' && genderStr.charAt(0) != 'm')) {
            throw new InvalidDataException("Неверный формат пола. Допустимые значения: f или m.");
        }
        return genderStr.charAt(0);
    }

    private int parseAge(String ageStr) throws InvalidDataException {
        try {
            int age = Integer.parseInt(ageStr);
            if (age < 0) {
                throw new InvalidDataException("Возраст не может быть отрицательным.");
            }
            return age;
        } catch (NumberFormatException e) {
            throw new InvalidDataException("Неверный формат возраста. Возраст должен быть целым числом.");
        }
    }

    private void writeToFile(Person person) throws IOException {
        String fileName = person.getLastName() + ".txt";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(person.toString() + "\n");
        }
    }
}