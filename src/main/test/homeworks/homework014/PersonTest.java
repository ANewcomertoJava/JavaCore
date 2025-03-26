package homeworks.homework014;

import homeworks.homework14.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testPersonCreation() {
        Person person = new Person("John", 100.0);
        assertEquals("John", person.getName());
        assertEquals(100.0, person.getMoney());
    }

    @Test
    public void testPersonCreationWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person("", 100.0);
        });
    }

    @Test
    public void testPersonCreationWithNegativeMoney() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person("John", -100.0);
        });
    }
}
