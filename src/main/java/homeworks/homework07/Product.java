package homeworks.homework07;

import java.util.Objects;

public class Product {
    private String productName;
    private double cost;

    // Конструктор
    public Product(String productName, double cost) {
        setProductName(productName);
        setCost(cost);
    }

    // Геттеры и сеттеры
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым.");
        } else if (!isValidProductName(productName)) {
            throw new IllegalArgumentException("Неверное название продукта.");
        }
        this.productName = productName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (cost <= 0) {
            throw new IllegalArgumentException("Стоимость не может быть нулевой или отрицательной.");
        }
        this.cost = cost;
    }

    // Проверяет валидность названия продукта
    protected boolean isValidProductName(String name) {
        return name.length() >= 3 && !name.matches("\\d+");
    }

    // Переопределенные методы
    @Override
    public String toString() {
        return String.format("Товар: %s, Цена: %.2f", productName, cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.cost, cost) == 0 &&
                Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, cost);
    }
}