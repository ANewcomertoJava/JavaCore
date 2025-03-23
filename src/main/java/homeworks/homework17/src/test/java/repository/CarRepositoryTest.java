package repository;

import model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.Impl.CarRepositoryFileImpl;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {
    private CarRepository carRepository;

    @BeforeEach
    void setUp() {
        carRepository = new CarRepositoryFileImpl();
        // Очищаем файл перед каждым тестом
        File file = new File("src/main/resources/cars.txt");
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testSaveAndGetAllCars() {
        // Создаем автомобиль
        Car car = new Car("Volga", "Number", 2019, 400, 5, 400, 900);

        // Сохраняем автомобиль
        carRepository.saveCar(car);

        // Получаем все автомобили
        List<Car> cars = carRepository.getAllCars();

        // Проверяем, что автомобиль был сохранен
        assertFalse(cars.isEmpty(), "Список автомобилей не должен быть пустым");
        assertEquals("Volga", cars.get(0).getBrand(), "Марка автомобиля должна быть Volga");
    }

    @Test
    void testGetCarById() {
        // Создаем автомобиль
        Car car = new Car("Ford", "Mustang", 2021, 450, 5, 350, 1200);

        // Сохраняем автомобиль
        carRepository.saveCar(car);

        // Получаем автомобиль по ID
        Car retrievedCar = carRepository.getCarById(0);

        // Проверяем, что автомобиль был найден
        assertNotNull(retrievedCar, "Автомобиль не должен быть null");
        assertEquals("Ford", retrievedCar.getBrand(), "Марка автомобиля должна быть Ford");
    }
}