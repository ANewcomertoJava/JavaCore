package homeworks.homework03;

public class App {
        public static void main(String[] args) {
        // создание экземпляров класса TelevisorUpdate
        Televisor tv1 = new Televisor("Samsung", "UE50DU7100UXRU", 50);
        Televisor tv2 = new Televisor("Sony", "KD-55X75K AF1", 54.6);
        Televisor tv3 = new Televisor("Thoshiba", "100Z670NE", 100);

        System.out.println(tv1.toString());
        System.out.println(tv2.toString());
        System.out.println(tv3.toString());
    }
}

