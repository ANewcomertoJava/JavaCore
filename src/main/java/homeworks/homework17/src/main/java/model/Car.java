package model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String brand;
    private String model;
    private int year;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    @Override
    public String toString() {
        return String.format("Brand: %s, Model: %s, Year: %d, Horsepower: %d, Acceleration: %d, Suspension: %d, Durability: %d",
                brand, model, year, horsepower, acceleration, suspension, durability);
    }
}