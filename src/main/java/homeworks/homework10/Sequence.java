package homeworks.homework10;

public class Sequence {
    public static int[] filter(int[] array, ByCondition condition) {
        int[] result = new int[array.length];
        int count = 0;

        for (int number : array) {
            if (condition.isOk(number)) {
                result[count++] = number;
            }
        }

        // Обрезаем массив до фактического размера
        int[] finalResult = new int[count];
        System.arraycopy(result, 0, finalResult, 0, count);
        return finalResult;
    }
}
