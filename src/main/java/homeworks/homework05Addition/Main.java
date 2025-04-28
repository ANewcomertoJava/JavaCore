package homeworks.homework05Addition;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение строки
        String s = scanner.nextLine();

        // Проверяем длину строки
        if (s.length() != 3) {
            System.out.println("Строка должна содержать ровно три символа.");
            return; // Завершаем программу, если длина неверная
        }

        // Находим индексы букв 'R', 'M' и 'S'
        int indexR = s.indexOf('R');
        int indexM = s.indexOf('M');
        int indexS = s.indexOf('S');

        // Проверяем наличие всех трёх букв
        if (indexR == -1 || indexM == -1 || indexS == -1) {
            System.out.println("Строка должна содержать одну букву 'R', одну букву 'M' и одну букву 'S'.");
            return; // Завершаем программу, если одной из букв нет
        }

        // Сравниваем индексы
        if (indexR < indexM) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        scanner.close(); // Закрываем сканер после использования
    }
}