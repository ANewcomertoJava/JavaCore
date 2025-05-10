package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GarageTest {
    @Test
    void testParkAndRemoveCar() {
        Garage garage = new Garage();
        Car car = new Car("Lada", "Kalina", 2022, 200, 3, 200, 1100);

        // Проверяем, что гараж пуст
        assertEquals(0, garage.getParkedCarsCount(), "Гараж должен быть пустым перед добавлением автомобиля");

        // Паркуем автомобиль
        garage.parkCar(car);
        assertEquals(1, garage.getParkedCarsCount(), "В гараже должен быть 1 автомобиль после парковки");

        // Удаляем автомобиль
        garage.removeCar(car);
        assertEquals(0, garage.getParkedCarsCount(), "Гараж должен быть пустым после удаления автомобиля");
    }
}