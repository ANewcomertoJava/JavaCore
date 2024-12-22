package homeworks.homework01;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // вводим условия
        System.out.println("Двое друзей играют в камень, ножницы, бумагу");
        System.out.println("Фигуры имеют числовые значения, где камень = 0, ножницы = 1, бумага = 2");
        //вводим числовые значения для каждого участника игры
        System.out.println("Что показал Вася =");
        int num1 = in.nextInt();
        System.out.println("Что показал Петя =");
        int num2 = in.nextInt();
        in.close();

        /// int num1 = 0;
        /// int num2 = 1;

        // проверяем результат
        if (num1 == num2){
            System.out.println("Ничья, следующая попытка");
        } else if ((num1 == 0)&&(num2 == 1)) {
            System.out.println("Победил Вася");
        } else if ((num1 == 0)&&(num2 == 2)) {
            System.out.println("Победил Петя");
        } else if ((num1 == 1)&&(num2 == 0)) {
            System.out.println("Победил Петя");
        } else if ((num1 == 1)&&(num2 == 2)) {
            System.out.println("Победил Вася");
        } else if ((num1 == 2)&&(num2 == 0)) {
            System.out.println("Победил Вася");
        } else if ((num1 == 2)&&(num2 == 1)) {
            System.out.println("Победил Петя");
        }

    }

}
