package homeworks.homework13.utils;



public class NumberValidator {

    // Метод для проверки условия
    public static <T> boolean validate(T value, ByCondition<T> condition) {
        return condition.test(value);
    }

    // Пример использования
    public static void main(String[] args) {
        // Условие: число должно быть положительным
        ByCondition<Integer> isPositive = value -> value > 0;

        // Условие: число должно быть меньше или равно 100
        ByCondition<Double> canAfford = value -> value <= 100.0;

        // Проверка целых чисел
        System.out.println(validate(10, isPositive)); // true
        System.out.println(validate(-5, isPositive)); // false

        // Проверка дробных чисел
        System.out.println(validate(50.0, canAfford)); // true
        System.out.println(validate(150.0, canAfford)); // false
    }
}
