package repository.Impl;

import model.Car;
import repository.CarRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepositoryFileImpl implements CarRepository {
    private static final String FILE_PATH = "src/main/resources/cars.txt";

    @Override
    public void saveCar(Car car) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(car.toString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Проверяем, что строка соответствует ожидаемому формату
                if (line.startsWith("Brand: ") && line.contains(", Model: ")) {
                    String[] parts = line.split(", ");
                    if (parts.length == 7) {
                        try {
                            String brand = parts[0].split(": ")[1];
                            String model = parts[1].split(": ")[1];
                            int year = Integer.parseInt(parts[2].split(": ")[1]);
                            int horsepower = Integer.parseInt(parts[3].split(": ")[1]);
                            int acceleration = Integer.parseInt(parts[4].split(": ")[1]);
                            int suspension = Integer.parseInt(parts[5].split(": ")[1]);
                            int durability = Integer.parseInt(parts[6].split(": ")[1]);

                            Car car = new Car(brand, model, year, horsepower, acceleration, suspension, durability);
                            cars.add(car);
                        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                            System.err.println("Ошибка при парсинге строки: " + line);
                        }
                    } else {
                        System.err.println("Некорректный формат строки: " + line);
                    }
                } else {
                    System.err.println("Некорректный формат строки: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public Car getCarById(int id) {
        List<Car> cars = getAllCars();
        if (id >= 0 && id < cars.size()) {
            return cars.get(id);
        }
        return null;
    }
}