package homeworks.homework09;


import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, year, (int) (horsepower * 1.5), acceleration, (int) (suspension * 0.75), durability);
        this.addOns = new ArrayList<>();
    }

    public void addAddOn(String addOn) {
        addOns.add(addOn);
    }

    @Override
    public String toString() {
        return super.toString() + ", Add-ons: " + addOns;
    }
}