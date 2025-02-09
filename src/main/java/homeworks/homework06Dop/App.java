package homeworks.homework06Dop;

public class App {
    public static void main(String[] args) {
        // Создаем программы
        Program program1 = new Program("Новости", 8.5, 1000);
        Program program2 = new Program("Фильм", 9.0, 1500);

        // Создаем каналы
        Channel channel1 = new Channel("Первый канал", 1, program1);
        Channel channel2 = new Channel("Россия 1", 2, program2);

        // Создаем телевизор и добавляем каналы
        TV tv = new TV();
        tv.addChannel(channel1);
        tv.addChannel(channel2);

        // Включаем телевизор и переключаем каналы
        tv.turnOn();
        tv.switchChannel(1);
        tv.switchChannel(2);
        tv.turnOff();
    }
}
