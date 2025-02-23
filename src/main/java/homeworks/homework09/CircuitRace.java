package homeworks.homework09;

public class CircuitRace extends Race {
    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool, 12);
        this.laps = laps;
    }

    @Override
    public String toString() {
        return super.toString() + ", Laps: " + laps;
    }
}