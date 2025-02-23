package homeworks.homework09;

public class TimeLimitRace extends Race {
    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool, 12);
        this.goldTime = goldTime;
    }

    @Override
    public String toString() {
        return super.toString() + ", Gold Time: " + goldTime;
    }
}