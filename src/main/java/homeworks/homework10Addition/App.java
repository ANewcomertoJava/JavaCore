package homeworks.homework10Addition;

public class App {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true

        System.out.println("Pair 1: " + pair);
        System.out.println("Pair 2: " + pair2);
        System.out.println("Пары равны: " + mustBeTrue);
        System.out.println("Хэш-коды равны: " + mustAlsoBeTrue);
    }
}
