package homeworks.homework09;

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

    @Override
    public String toString() {
        return "Garage: " + parkedCars.size() + " cars parked.";
    }
}
