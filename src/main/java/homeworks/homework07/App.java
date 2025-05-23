package homeworks.homework07;
import java.time.LocalDate;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Создание покупателей
            List<Person> buyers = new ArrayList<>();
            System.out.print("Введите количество покупателей: ");
            int numBuyers = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < numBuyers; i++) {
                System.out.print("Введите имя покупателя: ");
                String buyerName = scanner.nextLine();
                System.out.print("Введите сумму денег у покупателя: ");
                double buyerMoney = Double.parseDouble(scanner.nextLine());
                buyers.add(new Person(buyerName, buyerMoney));
            }

            // Создание товаров
            List<Product> products = new ArrayList<>();
            System.out.print("Введите количество товаров: ");
            int numProducts = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < numProducts; i++) {
                System.out.print("Введите название товара: ");
                String productName = scanner.nextLine();
                System.out.print("Введите цену товара: ");
                double productPrice = Double.parseDouble(scanner.nextLine());
                products.add(new Product(productName, productPrice));
            }

            // Добавляем скидку
            System.out.print("Хотите добавить скидку? (да/нет): ");
            String discountChoice = scanner.nextLine();
            if (discountChoice.equalsIgnoreCase("да")) {
                System.out.print("Введите название товара: ");
                String productName = scanner.nextLine();
                System.out.print("Введите цену товара: ");
                double productPrice = Double.parseDouble(scanner.nextLine());
                System.out.print("Введите процент скидки (0-100%): ");
                double discountPercent = Double.parseDouble(scanner.nextLine());
                LocalDate expirationDate = LocalDate.now().plusMonths(1);
                products.add(new DiscountProduct(productName, productPrice, discountPercent, expirationDate));
            }

            // Процесс покупки
            while (true) {
                for (Person buyer : buyers) {
                    System.out.println("\nТекущий покупатель: " + buyer.getName());
                    boolean boughtSomething = false;

                    for (Product product : products) {
                        if (buyer.getMoney() >= product.getCost()) {
                            System.out.printf("%s купил %s\n", buyer.getName(), product.getProductName());
                            buyer.setMoney(buyer.getMoney() - product.getCost());
                            boughtSomething = true;
                        } else {
                            System.out.printf("%s не может позволить себе %s\n",
                                    buyer.getName(), product.getProductName());
                        }
                    }

                    if (!boughtSomething) {
                        System.out.println(buyer.getName() + " ничего не куплено");
                    }
                }

                System.out.print("Продолжить покупки? (да/нет): ");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("нет")) {
                    break;
                }
            }

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
}