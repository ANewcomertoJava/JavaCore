import model.Car;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Чтение данных из файла


        try (InputStream inputStream = App.class.getClassLoader().getResourceAsStream("input.txt");
             Scanner scanner = new Scanner(inputStream)) {
            String brand = scanner.nextLine();
            String model = scanner.nextLine();
            int year = Integer.parseInt(scanner.nextLine());
            int horsepower = Integer.parseInt(scanner.nextLine());
            int acceleration = Integer.parseInt(scanner.nextLine());
            int suspension = Integer.parseInt(scanner.nextLine());
            int durability = Integer.parseInt(scanner.nextLine());

            // Создаем автомобиль
            Car car = new Car(brand, model, year, horsepower, acceleration, suspension, durability);

            // Запись результата в файл
            try (FileWriter writer = new FileWriter("src/main/java/homeworks/homework17/src/main/resources/output.txt")) {
                writer.write("Создан автомобиль:\n");
                writer.write(car.toString());
            } catch (IOException e) {
                System.err.println("Ошибка записи в файл: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }







    }
}