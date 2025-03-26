package homeworks.homework014;

import homeworks.homework14.App;
import homeworks.homework14.Person;
import homeworks.homework14.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class AppTest {

    // Группа тестов для метода extractBuyersFromInput
    @Test
    public void testExtractBuyersFromInput() {
        String input = "Евгений = 100, Алия = 200";
        List<Person> buyers = App.extractBuyersFromInput(input);
        assertEquals(2, buyers.size());
        assertEquals("Евгений", buyers.get(0).getName());
        assertEquals(100.0, buyers.get(0).getMoney());
        assertEquals("Алия", buyers.get(1).getName());
        assertEquals(200.0, buyers.get(1).getMoney());
    }

    @Test
    public void testExtractBuyersFromInput_EmptyInput() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> App.extractBuyersFromInput(input));
    }

    @Test
    public void testExtractBuyersFromInput_NegativeMoney() {
        String input = "Евгений = -100, Алия = 200";
        assertThrows(IllegalArgumentException.class, () -> {
            App.extractBuyersFromInput(input);
        }, "Баланс должен быть положительным!");
    }

    @Test
    public void testExtractBuyersFromInput_DecimalMoney() {
        String input = "Евгений = 100.50, Алия = 200.75";
        List<Person> buyers = App.extractBuyersFromInput(input);
        assertEquals(2, buyers.size());
        assertEquals("Евгений", buyers.get(0).getName());
        assertEquals(100.50, buyers.get(0).getMoney());
        assertEquals("Алия", buyers.get(1).getName());
        assertEquals(200.75, buyers.get(1).getMoney());
    }

    @Test
    public void testExtractBuyersFromInput_InvalidSeparator() {
        String input = "Евгений:100, Алия:200";
        assertThrows(IllegalArgumentException.class, () -> {
            App.extractBuyersFromInput(input);
        });
    }

    @Test
    public void testExtractBuyersFromInput_NullInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            App.extractBuyersFromInput(null);
        });
    }

    @Test
    public void testExtractBuyersFromInput_WithSpaces() {
        String input = "Евгений = 100,    Алия = 200";
        List<Person> buyers = App.extractBuyersFromInput(input);
        assertEquals(2, buyers.size());
        assertEquals("Евгений", buyers.get(0).getName());
        assertEquals(100.0, buyers.get(0).getMoney());
        assertEquals("Алия", buyers.get(1).getName());
        assertEquals(200.0, buyers.get(1).getMoney());
    }

    @Test
    public void testExtractBuyersFromInput_ExtraSpaces() {
        String input = "Евгений = 100 , Алия = 200";
        List<Person> buyers = App.extractBuyersFromInput(input);
        assertEquals(2, buyers.size());
        assertEquals("Евгений", buyers.get(0).getName());
        assertEquals(100.0, buyers.get(0).getMoney());
        assertEquals("Алия", buyers.get(1).getName());
        assertEquals(200.0, buyers.get(1).getMoney());
    }

    // Группа тестов для метода extractProductsFromInput
    @Test
    public void testExtractProductsFromInput() {
        String input = "Яблоко = 1.99, Банан = 0.99";
        List<Product> products = App.extractProductsFromInput(input);
        assertEquals(2, products.size());
        assertEquals("Яблоко", products.get(0).getProductName());
        assertEquals(1.99, products.get(0).getCost());
        assertEquals("Банан", products.get(1).getProductName());
        assertEquals(0.99, products.get(1).getCost());
    }

    @Test
    public void testExtractProductsFromInput_NegativePrice() {
        String input = "Яблоко = -1.99 Банан = 0.99";
        assertThrows(IllegalArgumentException.class, () -> {
            App.extractProductsFromInput(input);
        }, "Цена должна быть положительной!");
    }

    @Test
    public void testExtractProductsFromInput_NullInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            App.extractProductsFromInput(null);
        });
    }

    // Группа тестов для метода shoppingProcess
    @Test
    public void testShoppingProcess_SuccessfulPurchase() {
        List<Person> buyers = List.of(new Person("Евгений", 100), new Person("Алия", 200));
        List<Product> products = List.of(new Product("Яблоко", 50), new Product("Банан", 30));
        List<String> purchaseLines = List.of("Евгений Яблоко", "Алия Банан");

        List<String> results = App.shoppingProcess(purchaseLines, buyers, products);

        assertEquals(2, results.size());
        assertEquals("Евгений купил Яблоко", results.get(0));
        assertEquals("Алия купил Банан", results.get(1));
        assertEquals(50, buyers.get(0).getMoney()); // Проверка остатка денег
        assertEquals(170, buyers.get(1).getMoney()); // Проверка остатка денег
    }

    @Test
    public void testShoppingProcess_InsufficientFunds() {
        List<Person> buyers = List.of(new Person("Евгений", 10));
        List<Product> products = List.of(new Product("Яблоко", 50));
        List<String> purchaseLines = List.of("Евгений Яблоко");

        List<String> results = App.shoppingProcess(purchaseLines, buyers, products);

        assertEquals(1, results.size());
        assertEquals("Евгений не может позволить себе Яблоко", results.get(0));
        assertEquals(10, buyers.get(0).getMoney()); // Деньги не должны измениться
    }

    @Test
    public void testShoppingProcess_ProductNotFound() {
        List<Person> buyers = List.of(new Person("Евгений", 100));
        List<Product> products = List.of(new Product("Яблоко", 50));
        List<String> purchaseLines = List.of("Евгений Банан");

        List<String> results = App.shoppingProcess(purchaseLines, buyers, products);

        assertEquals(0, results.size()); // Ничего не должно произойти
    }

    @Test
    public void testShoppingProcess_BuyerNotFound() {
        List<Person> buyers = List.of(new Person("Евгений", 100));
        List<Product> products = List.of(new Product("Яблоко", 50));
        List<String> purchaseLines = List.of("Алексей Яблоко");

        List<String> results = App.shoppingProcess(purchaseLines, buyers, products);

        assertEquals(0, results.size()); // Ничего не должно произойти
    }

    @Test
    public void testShoppingProcess_ExactMoney() {
        List<Person> buyers = List.of(new Person("Евгений", 50));
        List<Product> products = List.of(new Product("Яблоко", 50));
        List<String> purchaseLines = List.of("Евгений Яблоко");

        List<String> results = App.shoppingProcess(purchaseLines, buyers, products);

        assertEquals(1, results.size());
        assertEquals("Евгений купил Яблоко", results.get(0));
        assertEquals(0, buyers.get(0).getMoney()); // Проверка остатка денег
    }

    @Test
    public void testShoppingProcess_BuyerWithSpaces() {
        List<Person> buyers = List.of(new Person("Евгений Иванов", 100));
        List<Product> products = List.of(new Product("Яблоко", 50));
        List<String> purchaseLines = List.of("Евгений Иванов Яблоко");

        List<String> results = App.shoppingProcess(purchaseLines, buyers, products);

        assertEquals(1, results.size());
        assertEquals("Евгений Иванов купил Яблоко", results.get(0));
        assertEquals(50, buyers.get(0).getMoney()); // Проверка остатка денег
    }

    @Test
    public void testShoppingProcess_EmptyBuyers() {
        List<Person> buyers = List.of();
        List<Product> products = List.of(new Product("Яблоко", 50));
        List<String> purchaseLines = List.of("Евгений Яблоко");

        List<String> results = App.shoppingProcess(purchaseLines, buyers, products);

        assertEquals(0, results.size()); // Ничего не должно произойти
    }

    @Test
    public void testShoppingProcess_EmptyProducts() {
        List<Person> buyers = List.of(new Person("Евгений", 100));
        List<Product> products = List.of();
        List<String> purchaseLines = List.of("Евгений Яблоко");

        List<String> results = App.shoppingProcess(purchaseLines, buyers, products);

        assertEquals(0, results.size()); // Ничего не должно произойти
    }

    // Группа тестов для метода findBuyerByName
    @Test
    public void testFindBuyerByName() {
        List<Person> buyers = List.of(new Person("Евгений", 100), new Person("Алия", 200));
        Person buyer = App.findBuyerByName(buyers, "Евгений");
        assertNotNull(buyer);
        assertEquals("Евгений", buyer.getName());
        assertEquals(100, buyer.getMoney());
    }

    @Test
    public void testFindBuyerByName_NotFound() {
        List<Person> buyers = List.of(new Person("Евгений", 100), new Person("Алия", 200));
        Person buyer = App.findBuyerByName(buyers, "Алексей");
        assertNull(buyer);
    }

    @Test
    public void testFindBuyerByName_CaseInsensitive() {
        List<Person> buyers = List.of(new Person("Евгений", 100));
        Person buyer = App.findBuyerByName(buyers, "евгений");
        assertNotNull(buyer);
        assertEquals("Евгений", buyer.getName());
    }

    // Группа тестов для метода findProductByName
    @Test
    public void testFindProductByName() {
        List<Product> products = List.of(new Product("Яблоко", 50), new Product("Банан", 30));
        Product product = App.findProductByName(products, "Яблоко");
        assertNotNull(product);
        assertEquals("Яблоко", product.getProductName());
        assertEquals(50, product.getCost());
    }

    @Test
    public void testFindProductByName_NotFound() {
        List<Product> products = List.of(new Product("Яблоко", 50), new Product("Банан", 30));
        Product product = App.findProductByName(products, "Апельсин");
        assertNull(product);
    }

    @Test
    public void testFindProductByName_CaseInsensitive() {
        List<Product> products = List.of(new Product("Яблоко", 50));
        Product product = App.findProductByName(products, "яблоко");
        assertNotNull(product);
        assertEquals("Яблоко", product.getProductName());
    }
}