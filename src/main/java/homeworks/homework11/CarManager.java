package homeworks.homework11;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CarManager {
    public static void main(String[] args) {
        // Загрузка данных об автомобилях
        List<Car> cars = loadCarsFromFile("src/main/java/homeworks/homework11/cars_data.txt");
        if (cars.isEmpty()) {
            System.out.println("Не удалось загрузить данные об автомобилях.");
            return;
        }

        // Загрузка параметров из файла
        List<String> params = loadParamsFromFile("src/main/java/homeworks/homework11/cars.txt");
        if (params.isEmpty()) {
            System.out.println("Не удалось загрузить параметры для фильтрации.");
            return;
        }

        // Парсинг параметров
        String colorToFind = params.get(0); // Первая строка: цвет
        long mileageToFind = Long.parseLong(params.get(1).replace("L", "")); // Вторая строка: пробег
        long minPrice = Long.parseLong(params.get(2).replace("L", "").replace("_", "")); // Третья строка: минимальная цена
        long maxPrice = Long.parseLong(params.get(3).replace("L", "").replace("_", "")); // Четвертая строка: максимальная цена
        String modelToFind1 = params.get(4); // Пятая строка: модель 1
        String modelToFind2 = params.get(5); // Шестая строка: модель 2

        // Вывод всех автомобилей
        printAllCars(cars);

        // Номера автомобилей по цвету или пробегу
        printCarsByColorOrMileage(cars, colorToFind, mileageToFind);

        // Уникальные модели в ценовом диапазоне
        printUniqueModelsInPriceRange(cars, minPrice, maxPrice);

        // Цвет автомобиля с минимальной стоимостью
        printColorOfCheapestCar(cars);

        // Средняя стоимость для заданных моделей
        printAverageCostByModel(cars, modelToFind1);
        printAverageCostByModel(cars, modelToFind2);
    }

    // Загрузка данных об автомобилях из файла
    private static List<Car> loadCarsFromFile(String fileName) {
        try (var lines = Files.lines(Paths.get(fileName))) {
            return lines
                    .map(line -> line.split("\\|"))
                    .filter(parts -> parts.length == 5)
                    .map(parts -> new Car(
                            parts[0].trim(),
                            parts[1].trim(),
                            Color.valueOf(parts[2].trim().toUpperCase()),
                            Long.parseLong(parts[3].trim()),
                            Long.parseLong(parts[4].trim())
                    ))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла с автомобилями: " + e.getMessage());
            return Collections.emptyList();
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка в формате данных: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    // Загрузка параметров из файла
    private static List<String> loadParamsFromFile(String fileName) {
        try (var lines = Files.lines(Paths.get(fileName))) {
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла с параметрами: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    // Вывод всех автомобилей
    private static void printAllCars(List<Car> cars) {
        System.out.println("Автомобили в базе:");
        System.out.printf("%-8s %-10s %-6s %-8s %s%n", "Number", "Model", "Color", "Mileage", "Cost");
        cars.forEach(System.out::println);
    }

    // Номера автомобилей по цвету или пробегу
    private static void printCarsByColorOrMileage(List<Car> cars, String colorToFind, long mileageToFind) {
        System.out.println("\nНомера автомобилей по цвету или пробегу:");
        cars.stream()
                .filter(car -> car.getColor() == Color.valueOf(colorToFind.toUpperCase()) || car.getMileage() == mileageToFind)
                .map(Car::getNumber)
                .forEach(number -> System.out.print(number + " "));
        System.out.println();
    }

    // Уникальные модели в ценовом диапазоне
    private static void printUniqueModelsInPriceRange(List<Car> cars, long minPrice, long maxPrice) {
        long uniqueModelsCount = cars.stream()
                .filter(car -> car.getCost() >= minPrice && car.getCost() <= maxPrice)
                .map(Car::getModel)
                .distinct()
                .count();
        System.out.println("\nУникальные автомобили: " + uniqueModelsCount + " шт.");
    }

    // Цвет автомобиля с минимальной стоимостью
    private static void printColorOfCheapestCar(List<Car> cars) {
        String minCostColor = cars.stream()
                .min(Comparator.comparingLong(Car::getCost))
                .map(car -> car.getColor().toString())
                .orElse("Не найден");
        System.out.println("\nЦвет автомобиля с минимальной стоимостью: " + minCostColor);
    }

    // Средняя стоимость для заданной модели
    private static void printAverageCostByModel(List<Car> cars, String model) {
        double averageCost = cars.stream()
                .filter(car -> car.getModel().equalsIgnoreCase(model))
                .mapToLong(Car::getCost)
                .average()
                .orElse(0.0);
        System.out.printf("\nСредняя стоимость модели %s: %.2f%n", model, averageCost);
    }
}