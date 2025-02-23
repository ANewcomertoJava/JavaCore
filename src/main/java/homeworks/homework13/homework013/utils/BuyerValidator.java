package homeworks.homework013.utils;


public class BuyerValidator {

    // Условие: число должно быть положительным
    public static boolean isPositive(Integer value) {
        return value > 0;
    }

    // Условие: сумма должна быть достаточной для покупки
    public static boolean canAfford(Double balance, Double price) {
        return balance >= price;
    }

    // Пример использования
    public static void main(String[] args) {
        Integer quantity = 5;
        Double balance = 100.0;
        Double price = 50.0;

        // Проверка условий
        System.out.println("Количество положительное: " + isPositive(quantity)); // true
        System.out.println("Достаточно средств: " + canAfford(balance, price)); // true

        // Пример с отрицательным числом
        System.out.println("Количество положительное: " + isPositive(-5)); // false

        // Пример с недостаточными средствами
        System.out.println("Достаточно средств: " + canAfford(30.0, 50.0)); // false
    }
}
