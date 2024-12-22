package homeworks.homework02;/*
Задача 2. Напишите программу на Java, которая принимает два целых
числа от пользователя, а затем печатает сумму, разницу, произведение, среднее
значение, расстояние (разница между целыми числами), максимум (большее из
двух целых чисел), минимум (меньшее из двух целых чисел).
*/

import java.util.Scanner;
import java.lang.Math;

public class MathematicalOperations {
    public static void main(String[] args) {
        int max;
        int min;

        //запрашиваем значения у пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое целое число: ");
        int numb1 = scanner.nextInt();
        System.out.println("Введите второе целое число: ");
        int numb2 = scanner.nextInt();
        scanner.close();


        //int numb1 = 25;
        //int numb2 = 5;

        if (numb1 > numb2) {
            max = numb1;
            min = numb2;
        } else {
            max = numb2;
            min = numb1;
        }

        double average  = (double) Math.abs(numb1 + numb2) / 2;
        int distance = Math.abs(max - min);

        System.out.println("Сумма двух целых чисел: " + (numb1 + numb2));
        System.out.println("Разница двух целых чисел: " + (numb1 - numb2));
        System.out.println("Произведение из двух целых чисел: "+ (numb1 * numb2));
        System.out.println("Среднее из двух целых чисел: " + average );
        System.out.println("Расстояние двух целых чисел: " + distance);
        System.out.println("Максимальное целое число: "+ max);
        System.out.println("Минимальное целое число: " + min);


    }
}
