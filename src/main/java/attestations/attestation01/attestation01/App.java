package attestations.attestation01;

import attestations.attestation01.exceptions.FileOperationException;
import attestations.attestation01.exceptions.InvalidDataException;
import attestations.attestation01.exceptions.UserNotFoundException;
import attestations.attestation01.model.User;
import attestations.attestation01.repository.Impl.UsersRepositoryFileImpl;
import attestations.attestation01.repository.UsersRepository;

import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        try {
            UsersRepository repository = new UsersRepositoryFileImpl();

            // Создание пользователя
            User user = new User(
                    "123",
                    LocalDateTime.now(),
                    "user123",
                    "password123",
                    "password123",
                    "Иванов",
                    "Иван",
                    "Иванович",
                    30,
                    false
            );
            repository.create(user);

            // Поиск пользователя по ID
            User foundUser = repository.findById("123");
            System.out.println("Найден пользователь: " + foundUser);

            // Обновление пользователя
            foundUser.setAge(35);
            repository.update(foundUser);

            // Удаление пользователя
            repository.deleteById("123");

        } catch (UserNotFoundException | FileOperationException | InvalidDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}