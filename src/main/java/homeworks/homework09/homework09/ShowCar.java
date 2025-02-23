package homeworks.homework09;

public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, year, horsepower, acceleration, suspension, durability);
        this.stars = 0;
    }

    public void increaseStars(int stars) {
        this.stars += stars;
    }

    @Override
    public String toString() {
        return super.toString() + ", Stars: " + stars;
    }
}