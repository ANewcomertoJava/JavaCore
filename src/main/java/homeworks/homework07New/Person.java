package homeworks.homework07New;

import java.util.Objects;

public class Person {
    private String name;
    private double money;

    // Конструктор
    public Person(String name, double money) {
        setName(name);
        setMoney(money);
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

    // Переопределенные методы
    @Override
    public String toString() {
        return "Покупатель: " + name + ", Деньги: " + money;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money);
    }


    public boolean canBuyProduct(Product product) {
        return getMoney() >= product.getCost();
    }

    public void addPurchasedProduct(Product product) {
    }
}
