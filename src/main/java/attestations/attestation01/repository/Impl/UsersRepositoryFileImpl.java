package attestations.attestation01.repository.Impl;


import attestations.attestation01.exceptions.FileOperationException;
import attestations.attestation01.exceptions.UserNotFoundException;
import attestations.attestation01.model.User;
import attestations.attestation01.repository.UsersRepository;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryFileImpl implements UsersRepository {
    private static final String FILE_NAME = "users.txt";
    private static final List<User> users = new ArrayList<>();

    public UsersRepositoryFileImpl() {
        try {
            loadFromFile();
        } catch (FileOperationException e) {
            // Логируем ошибку, но продолжаем работу с пустым списком
            System.err.println("Предупреждение: " + e.getMessage());
            users.clear();
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);

        // Если файла нет, просто возвращаемся (создадим его при первой записи)
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                users.add(new User(line));
            }
        } catch (IOException e) {
            throw new FileOperationException("Ошибка чтения файла", e);
        }
    }

    @Override
    public void create(User user) {
        users.add(user);
        saveToFile();
    }

    @Override
    public User findById(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("Пользователя с идентификатором " + id + " не существует"));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public void update(User user) {
        boolean found = users.removeIf(u -> u.getId().equals(user.getId()));
        if (!found) {
            throw new UserNotFoundException("Пользователя с идентификатором " + user.getId() + " не существует");
        }
        users.add(user);
        saveToFile();
    }

    @Override
    public void deleteById(String id) {
        boolean removed = users.removeIf(user -> user.getId().equals(id));
        if (!removed) {
            throw new UserNotFoundException("Пользователя с идентификатором " + id + " не существует");
        }
        saveToFile();
    }

    @Override
    public void deleteAll() {
        users.clear();
        saveToFile();
    }

    private void saveToFile() {
        try {
            // Создаем файл, если его нет
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }

            // Записываем данные
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (User user : users) {
                    writer.write(user.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new FileOperationException("Ошибка записи в файл", e);
        }
    }

    }