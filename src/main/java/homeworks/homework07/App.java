package homeworks.homework07;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Чтение списка покупателей
            System.out.print("Введите имена и деньги покупателей через равно: ");
            String input = scanner.nextLine();

            List<Person> buyers = extractBuyersFromInput(input);

            for (Person buyer : buyers) {
                System.out.println(buyer);
            }

            // Чтение списка товаров
            System.out.print("Введите названия и цены товаров через равно: ");
            String inputProduct = scanner.nextLine();

            List<Product> products = extractProductsFromInput(inputProduct);

            for (Product product : products) {
                System.out.println(product);
            }

            // Процесс покупки
            List<String> purchaseLines = new ArrayList<>();
            while (true) {
                System.out.print("Введите имя покупателя и название товара через пробел или 'END' для завершения: ");
                String inputPurchase = scanner.nextLine().trim();

                if (inputPurchase.equalsIgnoreCase("END")) {
                    break;
                }

                purchaseLines.add(inputPurchase);
            }

            // Обработка покупок
            List<String> results = shoppingProcess(purchaseLines, buyers, products);

            // Вывод результатов
            System.out.println("\nРезультаты покупок:");
            for (String result : results) {
                System.out.println(result);
            }

            // Итоговый вывод
            System.out.println("\nИтоги:");
            for (Person buyer : buyers) {
                System.out.println(buyer.toString());
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка ввода данных: неверный формат ввода.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    private static List<Person> extractBuyersFromInput(String input) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Вводная строка не может быть пустой!");
        }

        List<Person> buyers = new ArrayList<>();
        String[] namesAndMoney = input.split("=");

        if (namesAndMoney.length < 2) {
            throw new IllegalArgumentException("Неверный формат записи покупателя: " + input);
        }

        String name = namesAndMoney[0].trim();
        double money;
        try {
            money = Double.parseDouble(namesAndMoney[1].trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректная сумма денег: " + namesAndMoney[1]);
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым!");
        }

        if (money <= 0) {
            throw new IllegalArgumentException("Деньги должны быть положительными!");
        }

        buyers.add(new Person(name, money));
        return buyers;
    }

    private static List<Product> extractProductsFromInput(String input) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Вводная строка не может быть пустой!");
        }

        List<Product> products = new ArrayList<>();
        String[] productEntries = input.split(" ");

        for (String productEntry : productEntries) {
            String[] parts = productEntry.split("=");
            if (parts.length < 2) {
                throw new IllegalArgumentException("Неверный формат записи продукта: " + productEntry);
            }

            String productName = parts[0].trim();
            String priceAndDiscount = parts[1].trim();

            if (priceAndDiscount.contains("%")) {
                String[] priceDiscountParts = priceAndDiscount.split(",");
                double price = Double.parseDouble(priceDiscountParts[0].trim());
                double discountPercent = Double.parseDouble(priceDiscountParts[1].replace("%", "").trim());
                LocalDate expirationDate = LocalDate.now().plusDays(7); // Пример: скидка действует 7 дней
                if (price <= 0 || discountPercent < 0 || discountPercent > 100) {
                    throw new IllegalArgumentException("Цена и скидка должны быть корректными!");
                }

                products.add(new DiscountProduct(productName, price, discountPercent, expirationDate));
            } else {
                double price = Double.parseDouble(priceAndDiscount);
                if (price <= 0) {
                    throw new IllegalArgumentException("Цена должна быть положительной!");
                }

                products.add(new Product(productName, price));
            }
        }

        return products;
    }

    private static List<String> shoppingProcess(List<String> purchaseLines, List<Person> buyers, List<Product> products) {
        List<String> results = new ArrayList<>();

        for (String line : purchaseLines) {
            if ("END".equals(line)) {
                break;
            }

            String[] parts = line.split(" ");
            if (parts.length == 2) {
                String buyerName = parts[0];
                String productName = parts[1];

                Person buyer = findBuyerByName(buyers, buyerName);
                Product product = findProductByName(products, productName);

                if (buyer != null && product != null) {
                    if (buyer.canBuyProduct(product)) {
                        buyer.setMoney(buyer.getMoney() - product.getCost());
                        buyer.addPurchasedProduct(product);
                        results.add(buyer.getName() + " купил " + product.getProductName());
                    } else {
                        results.add(buyer.getName() + " не может позволить себе " + product.getProductName());
                    }
                }
            }
        }

        return results;
    }

    private static Person findBuyerByName(List<Person> buyers, String name) {
        for (Person buyer : buyers) {
            if (buyer.getName().equalsIgnoreCase(name)) {
                return buyer;
            }
        }

        return null;
    }

    private static Product findProductByName(List<Product> products, String name) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                return product;
            }
        }

        return null;
    }
}