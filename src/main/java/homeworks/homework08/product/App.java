package homeworks.homework08.product;

import homeworks.homework08.person.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) throws IOException {
        // Чтение данных из файла input.txt
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/homeworks/homework08/product/input.txt"));

        // Разделение строки с покупателями и продуктами
        String buyersData = lines.get(0);
        String productsData = lines.get(1);
        List<String> purchaseLines = lines.subList(2, lines.size());

        // Парсинг данных покупателей
        List<Person> buyers = parseBuyers(buyersData);

        // Парсинг данных продуктов
        List<Product> products = parseProducts(productsData);

        // Выполнение покупок
        List<String> results = processPurchases(purchaseLines, buyers, products);

        // Запись результатов в файл output.txt
        File file = new File("src/main/java/homeworks/homework08/product/output.txt");
        Files.write(file.toPath(), results);

        System.out.println("Результаты сохранены в файл output.txt");
    }

    // Метод для парсинга строк с покупателями
    private static List<Person> parseBuyers(String data) {
        List<Person> buyers = new ArrayList<>();
        String[] parts = data.split(";");

        for (String part : parts) {
            String[] info = part.split("=");
            String name = info[0].trim();
            double money = Double.parseDouble(info[1].trim());
            buyers.add(new Person(name, money));
        }

        return buyers;
    }

    // Метод для парсинга строк с продуктами
    private static List<Product> parseProducts(String data) {
        List<Product> products = new ArrayList<>();
        String[] parts = data.split(";");

        for (String part : parts) {
            String[] info = part.split("=");
            String productName = info[0].trim();
            double price = Double.parseDouble(info[1].trim());
            products.add(new Product(productName, price));
        }

        return products;
    }

    private static List<String> processPurchases(List<String> purchaseLines, List<Person> buyers, List<Product> products) {
        List<String> results = new ArrayList<>();

        for (String line : purchaseLines) {
            if ("END".equals(line)) {
                break;
            }

            String[] parts = line.split(" ");
            if (parts.length == 2) {
                String buyerName = parts[0];
                String productName = parts[1];
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
                        results.add(buyer.getName() + " купил " + product.getProductName());
                    } else {
                        results.add(buyer.getName() + " не может позволить себе " + product.getProductName());
                    }
                }
            }
        }

        // Итоговый отчет
        for (Person buyer : buyers) {
            results.add(buyer.toString());
        }

        return results;
    }

    // Метод для поиска покупателя по имени
    private static Person findBuyerByName(List<Person> buyers, String name) {
        for (Person buyer : buyers) {
            if (buyer.getName().equals(name)) {
                return buyer;
            }
        }
        return null;
    }

    // Метод для поиска продукта по названию
    private static Product findProductByName(List<Product> products, String name) {
        for (Product product : products) {
            if (product.getProductName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}