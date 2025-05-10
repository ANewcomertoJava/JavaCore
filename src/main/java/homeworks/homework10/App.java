package homeworks.homework10;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Фильтрация четных чисел
        int[] evenNumbers = Sequence.filter(numbers, n -> n % 2 == 0);
        System.out.println("Четные числа: " + Arrays.toString(evenNumbers));

        // Фильтрация чисел, у которых сумма цифр четная
        int[] sumEvenNumbers = Sequence.filter(numbers, n -> {
            int sum = 0;
            int num = n;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum % 2 == 0;
        });
        System.out.println("Числа с четной суммой цифр: " + Arrays.toString(sumEvenNumbers));
    }
}
