package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void testCarCreation() {
        Car car = new Car("Ford Fockus", "Ford", 2021, 300, 3, 200, 900);
        assertEquals("Ford Fockus", car.getBrand());
        assertEquals("Ford", car.getModel());
        assertEquals(2021, car.getYear());
        assertEquals(300, car.getHorsepower());
    }
}