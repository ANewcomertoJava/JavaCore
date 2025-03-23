package homeworks.homework09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // Чтение данных из файла
        try (Scanner scanner = new Scanner(new File("src/main/java/homeworks/homework09/input.txt"))) {
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
            try (FileWriter writer = new FileWriter("src/main/java/homeworks/homework09/output.txt")) {
                writer.write("Создан автомобиль:\n");
                writer.write(car.toString());
            } catch (IOException e) {
                System.err.println("Ошибка записи в файл: " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }


        /*
        // Создаем автомобили
        Car car1 = new Car("Toyota", "Supra", 2020, 500, 4, 300, 1000);
        PerformanceCar car2 = new PerformanceCar("Ferrari", "488 GTB", 2021, 700, 3, 400, 1200);
        ShowCar car3 = new ShowCar("Lamborghini", "Aventador", 2022, 800, 2, 500, 1500);

        // Создаем гараж
        Garage garage = new Garage();

        // Паркуем автомобили в гараж
        garage.parkCar(car1);
        garage.parkCar(car2);

        // Модифицируем автомобиль Ferrari
        garage.modifyCar(car2, 800, 450);

        // Выводим информацию о гараже
        System.out.println(garage);
        System.out.println(car2);

        // Создаем PerformanceCar
        PerformanceCar car4 = new PerformanceCar("Ferrari", "488 GTB", 2021, 700, 3, 400, 1200);
        car4.addAddOn("Turbo Boost");
        car4.addAddOn("Aerodynamic Kit");

        // Создаем ShowCar
        ShowCar car5 = new ShowCar("Lamborghini", "Aventador", 2022, 800, 2, 500, 1500);
        car5.increaseStars(5);

        // Выводим информацию о автомобилях
        System.out.println(car4);
        System.out.println(car5);

        // Создаем гонку
        Race casualRace = new Race(100, "City Circuit", 50000, 12);

        // Создаем специализированные гонки
        TimeLimitRace timeLimitRace = new TimeLimitRace(200, "Mountain Pass", 100000, 120);
        CircuitRace circuitRace = new CircuitRace(300, "Grand Prix Circuit", 200000, 5);



        // Добавляем участников в гонку
        casualRace.addParticipant(car1);
        casualRace.addParticipant(car2);
        casualRace.addParticipant(car3);

        // Добавляем участников  в спец гонки
        timeLimitRace.addParticipant(car1);
        circuitRace.addParticipant(car2);

        // Выводим информацию о гонке
        System.out.println(casualRace);
        System.out.println(timeLimitRace);
        System.out.println(circuitRace);
    */


    }
}






