package homeworks.homework11;

import java.util.Objects;

public class Car {
    private String number;
    private String model;
    private Color color;
    private long mileage;
    private long cost;

    public Car(String number, String model, Color color, long mileage, long cost) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.cost = cost;
    }

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public Color getColor() {
        return color;
    }

    public long getMileage() {
        return mileage;
    }

    public long getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return String.format("%-8s %-10s %-6s %-8d %d", number, model, color, mileage, cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(number, car.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}