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

    @Override
    public void create(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(user.toString());
            writer.newLine();
        } catch (IOException e) {
            throw new FileOperationException("Ошибка записи в файл", e);
        }
    }

    @Override
    public User findById(String id) {
        return findAll().stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("Пользователя с идентификатором " + id + " не существует"));
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                users.add(new User(
                        parts[0],
                        LocalDateTime.parse(parts[1]),
                        parts[2],
                        parts[3],
                        parts[4],
                        parts[5],
                        parts[6],
                        parts[7],
                        Integer.parseInt(parts[8]),
                        Boolean.parseBoolean(parts[9])
                ));
            }
        } catch (IOException e) {
            throw new FileOperationException("Ошибка чтения файла", e);
        }
        return users;
    }

    @Override
    public void update(User user) {
        List<User> users = findAll();
        boolean found = users.removeIf(u -> u.getId().equals(user.getId()));
        if (!found) {
            throw new UserNotFoundException("Пользователя с идентификатором " + user.getId() + " не существует");
        }
        users.add(user);
        writeAll(users);
    }

    @Override
    public void deleteById(String id) {
        List<User> users = findAll();
        boolean removed = users.removeIf(user -> user.getId().equals(id));
        if (!removed) {
            throw new UserNotFoundException("Пользователя с идентификатором " + id + " не существует");
        }
        writeAll(users);
    }

    @Override
    public void deleteAll() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("");
        } catch (IOException e) {
            throw new FileOperationException("Ошибка очистки файла", e);
        }
    }

    private void writeAll(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User user : users) {
                writer.write(user.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new FileOperationException("Ошибка записи в файл", e);
        }
    }
}