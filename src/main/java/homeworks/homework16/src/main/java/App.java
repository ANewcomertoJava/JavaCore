

import exceptions.FileOperationException;
import exceptions.InvalidDataException;
import exceptions.UserNotFoundException;
import model.User;
import repository.Impl.UsersRepositoryFileImpl;
import repository.UsersRepository;

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