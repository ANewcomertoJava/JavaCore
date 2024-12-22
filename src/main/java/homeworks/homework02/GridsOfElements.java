package homeworks.homework02;/*
Задача 4*. Напишите программу на Java для печати сетки из заданных
элементов.
 */
import java.util.Scanner;
public class GridsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество строк ");
        int rows = scanner.nextInt();
        System.out.println("Введите количество столбцов ");
        int columns = scanner.nextInt();
        System.out.println("Введите повторяемый элемент ");
        String gridelements = scanner.next();
        scanner.close();
        /*
        //повторяемый элемент сетки
        String gridelements = "-";
        //задаем количесвто строк и столбцов в таблице
        int rows = 3;
        int columns = 5;
         */
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                System.out.print(gridelements);
            }
            System.out.println();
        }
    }
}
