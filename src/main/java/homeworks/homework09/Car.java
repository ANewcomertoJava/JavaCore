package homeworks.homework09;

import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private int year;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    public Car(String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.horsepower = horsepower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    // Геттеры и сеттеры
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String brand) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public int getYear() {
        return year;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
    public int getHorsepower() {
        return horsepower;
    }

    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }
    public int getSuspension() {
        return suspension;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }
    public int getAcceleration() {
        return acceleration;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
    public int getDurability() {
        return durability;
    }






    @Override
    public String toString() {
        return String.format("%s %s (%d) - %d HP, %d Suspension, %d Durability",
                brand, model, year, horsepower, suspension, durability);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return year == car.year &&
                horsepower == car.horsepower &&
                acceleration == car.acceleration &&
                suspension == car.suspension &&
                durability == car.durability &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, horsepower, acceleration, suspension, durability);
    }




}
