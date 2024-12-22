package homeworks.homework02;/*
Задача 3*. Напишите Java-программу для объединения данной строки с
самим собой заданное количество раз.
 */

public class CombiString {
    public static void main(String[] args) {
        String word = "Java";
        //создаем переменную n, которая будет означать количество повторений
        int n = 8;
        for (int i = 0; i < n; i++) {
            System.out.print(word);
        }
    }
}
