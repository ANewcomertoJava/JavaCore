package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RaceTest {
    @Test
    void testAddParticipant() {
        Race race = new Race(100, "City Circuit", 50000);
        Car car = new Car("Toyota", "Supra", 2020, 500, 4, 300, 1000);

        // Добавляем участника
        race.addParticipant(car);

        // Проверяем, что количество участников равно 1
        assertEquals(1, race.getParticipants().size(), "Количество участников должно быть равно 1");
    }
}