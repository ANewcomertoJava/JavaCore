package homeworks.homework014;

import homeworks.homework14.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testProductCreation() {
        Product product = new Product("Apple", 1.99);
        assertEquals("Apple", product.getProductName());
        assertEquals(1.99, product.getCost());
    }

    @Test
    public void testProductCreationWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Product("", 1.99);
        });
    }

    @Test
    public void testProductCreationWithNegativeCost() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Product("Apple", -1.99);
        });
    }
}
