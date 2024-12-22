package homeworks.homework05Addition;



public class AppUpdate {
        public static void main(String[] args) {

                TelevisorUpdate tv1 = new TelevisorUpdate("Rubin", "OZOZNE10101", 120);
                TelevisorUpdate tv2 = new TelevisorUpdate("Rubin", "OZOZNE10101", 120);

                tv1.setCurrentChannel(10);    // Меняем канал
                tv1.setVolume(75);            // Повышаем громкость
                tv1.setIsOn(true);            // Включаем телевизор

                System.out.println(tv1.toString());


                // Сравниваем два одинаковых телевизора
                tv2.setCurrentChannel(10);
                tv2.setVolume(75);
                tv2.setIsOn(true);

                System.out.println("Сравниваем два телевизора:");
                System.out.println(tv1.equals(tv2));  // Должно вывести true
        }
}
