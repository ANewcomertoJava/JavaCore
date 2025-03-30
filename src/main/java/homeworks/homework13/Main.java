package homeworks.homework13;

import homeworks.homework13.utils.NumberParser;

public class Main {
    public static void main(String[] args) {
        // Пример работы с целыми числами
        String validInt = "123";
        String invalidInt = "abc";

        System.out.println("Парсинг validInt: " + NumberParser.validateCount(validInt)); // 123
        System.out.println("Парсинг invalidInt: " + NumberParser.validateCount(invalidInt)); // null

        // Пример работы с дробными числами
        String validDouble = "123.45";
        String invalidDouble = "xyz";

        System.out.println("Парсинг validDouble: " + NumberParser.validateNumber(validDouble)); // 123.45
        System.out.println("Парсинг invalidDouble: " + NumberParser.validateNumber(invalidDouble)); // null
    }
}
