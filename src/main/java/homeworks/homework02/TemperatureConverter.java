package homeworks.homework02;/*
Задача 1. Напишите Java-программу для преобразования температуры из
Фаренгейта в градусы Цельсия.
*/
import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //запрашиваем значения у пользователя
        System.out.println("Введите температру в градусах Фаренгейта: ");
        double farengeit = scanner.nextDouble();
        scanner.close();

        //double farengeit = 212;
        // Формула перевода из Фаренгейта в Цельсий
        double celsii = (farengeit - 32) * 5 / 9;
        // выводим на экран результат
        System.out.println(farengeit +" градусов по Фаренгейту соответсвует "+ celsii + " по Цельсию" );
    }
}