package homeworks.homework014;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
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
        } catch (InputMismatchException | NumberFormatException e) {
            System.err.println("Ошибка ввода данных: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static List<Person> extractBuyersFromInput(String input) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Входная строка не может быть пустой!");
        }

        List<Person> buyers = new ArrayList<>();

        // Регулярное выражение для поиска пар "имя = деньги"
        Pattern pattern = Pattern.compile("([^=]+)\\s*=\\s*(\\d+)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String name = matcher.group(1).trim();      // Имя покупателя
            double money = Double.parseDouble(matcher.group(2)); // Деньги покупателя

            if (money <= 0) {
                throw new IllegalArgumentException("Деньги должны быть положительными!");
            }

            if (name.isEmpty()) {
                throw new IllegalArgumentException("Имя не может быть пустым!");
            }

            buyers.add(new Person(name, money));
        }

        return buyers;
    }

    private static List<Product> extractProductsFromInput(String input) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Входная строка не может быть пустой!");
        }

        List<Product> products = new ArrayList<>();

        // Регулярное выражение для поиска пар "название товара = цена"
        Pattern pattern = Pattern.compile("([^=]+)\\s*=\\s*(\\d+)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String productName = matcher.group(1).trim();  // Название товара
            double productPrice = Double.parseDouble(matcher.group(2)); // Цена товара

            if (productPrice <= 0) {
                throw new IllegalArgumentException("Цена должна быть положительной!");
            }

            if (productName.isEmpty()) {
                throw new IllegalArgumentException("Название товара не может быть пустым!");
            }

            products.add(new Product(productName, productPrice));
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
                    if (buyer.getMoney() >= product.getCost()) {
                        buyer.setMoney(buyer.getMoney() - product.getCost());
                        buyer.addPurchasedProduct(product);
                        results.add(buyer.getName() + " купил " + product.getProductName());
                    } else {
                        results.add(buyer.getName() + " не может позволить себе " + product.getProductName());
                    }
                }
            } else if (parts.length >= 3) {
                // Если строка содержит больше двух слов, собираем имя покупателя из первых двух слов
                String buyerName = parts[0] + " " + parts[1];

                // Название продукта начинается с третьего слова до конца строки
                StringBuilder sb = new StringBuilder();
                for (int i = 2; i < parts.length; i++) {
                    sb.append(parts[i]).append(" ");
                }
                String productName = sb.toString().trim(); // Убираем лишние пробелы в конце

                Person buyer = findBuyerByName(buyers, buyerName);
                Product product = findProductByName(products, productName);

                if (buyer != null && product != null) {
                    if (buyer.getMoney() >= product.getCost()) {
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