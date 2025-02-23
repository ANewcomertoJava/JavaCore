package homeworks.homework013.utils;



public class NumberParser {

    // Метод для парсинга строки в целое число (Integer)
    public static Integer parseCount(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Невалидное значение: " + input);
        }
    }

    // Метод для валидации и возврата результата парсинга
    public static Integer validateCount(String input) {
        try {
            return parseCount(input);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    // Метод для парсинга строки в дробное число (Double)
    public static Double parseNumber(String input) throws IllegalArgumentException {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Невалидное значение: " + input);
        }
    }

    // Метод для валидации и возврата результата парсинга дробного числа
    public static Double validateNumber(String input) {
        try {
            return parseNumber(input);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
