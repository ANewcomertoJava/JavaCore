package homeworks.homework04;/*Задача 1. Для введенной с клавиатуры буквы английского алфавита
        нужно вывести слева стоящую букву на стандартной клавиатуре. При этом
        клавиатура замкнута, т.е. справа от буквы «p» стоит буква «a», а слева от "а"
        буква "р", также соседними считаются буквы «l» и буква «z», а буква «m» с
        буквой «q».
*/


import java.util.Scanner;

public class LetterEnKeyboard {
    public static void main(String[] args) {
        char[] enKeyboard = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите букву английского алфавита:");
        char inputLetter = scanner.nextLine().toLowerCase().charAt(0); // Получаем первый символ введённого текста и приводим его к нижнему регистру.
        scanner.close();

        boolean found = false;
        for (int i = 0; i < enKeyboard.length; i++) {
            if (enKeyboard[i] == inputLetter) {
                char leftLetter;
                if (i > 0) {
                    leftLetter = enKeyboard[i - 1]; // Берём букву слева, если она существует.
                } else {
                    leftLetter = enKeyboard[enKeyboard.length - 1]; // Для первой буквы возвращаемся к последней букве клавиатуры.
                }

                System.out.println("Слева стоящая буква от " + inputLetter + " это " + leftLetter);
                found = true;
                break; // Прекращаем цикл после нахождения нужной буквы.
            }
        }

        if (!found) {
            System.out.println("Буквы " + inputLetter + " нет в английском алфавите.");
        }
    }
}