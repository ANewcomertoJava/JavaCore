package model;
import java.util.ArrayList;
import java.util.List;

public class Garage {
    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public void parkCar(Car car) {
        parkedCars.add(car);
    }

    public void modifyCar(Car car, int horsepower, int suspension) {
        car.setHorsepower(horsepower);
        car.setSuspension(suspension);
    }

    public void removeCar(Car car) {
        parkedCars.remove(car); // Удаляем автомобиль из списка
    }

    public int getParkedCarsCount() {
        return parkedCars.size(); // Возвращаем количество припаркованных автомобилей
    }

    @Override
    public String toString() {
        return "Garage: " + parkedCars.size() + " cars parked.";
    }
}