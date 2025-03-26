package homeworks.homework14;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private double money;
    private List<Product> purchasedProducts;

    // Конструктор
    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.purchasedProducts = new ArrayList<>();
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными.");
        }
        this.money = money;
    }

    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    // Метод для добавления купленного товара
    public void addPurchasedProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Товар не может быть null.");
        }
        purchasedProducts.add(product);
    }

    // Переопределенные методы
    @Override
    public String toString() {
        return "Покупатель: " + name + ", Деньги: " + money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Double.compare(person.money, money) == 0 &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money);
    }
}
