package repository;

import model.Car;
import java.util.List;

public interface CarRepository {
    void saveCar(Car car);
    List<Car> getAllCars();
    Car getCarById(int id);
}