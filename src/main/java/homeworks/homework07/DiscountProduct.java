package homeworks.homework07;

import java.time.LocalDate;
import java.util.Objects;

public class DiscountProduct extends Product {
    private double discountPercent;
    private LocalDate expirationDate;

    // Конструктор
    public DiscountProduct(String productName, double cost, double discountPercent, LocalDate expirationDate) {
        super(productName, cost); // Вызов конструктора родительского класса
        setDiscountPercent(discountPercent);

    }

    // Геттеры и сеттеры
    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть между 0 и 100.");
        }
        this.discountPercent = discountPercent;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }



    // Метод для получения стоимости с учетом скидки
    public double getDiscountedPrice() {
        if (LocalDate.now().isAfter(getExpirationDate())) {
            return getCost(); // Скидка больше не действует
        }
        return getCost() * (1 - getDiscountPercent() / 100);
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return String.format(
                "Скидочный товар: %s, Цена без скидки: %.2f, Скидка: %.2f%%, Срок действия скидки до: %s",
                getProductName(),
                getCost(),
                getDiscountPercent(),
                getExpirationDate());
    }

    // Переопределенный метод equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiscountProduct)) return false;
        if (!super.equals(o)) return false;
        DiscountProduct that = (DiscountProduct) o;
        return Double.compare(that.discountPercent, discountPercent) == 0 &&
                Objects.equals(expirationDate, that.expirationDate);
    }

    // Переопределенный метод hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discountPercent, expirationDate);
    }
}