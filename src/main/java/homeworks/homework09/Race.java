package homeworks.homework09;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    public Race(int length, String route, int prizePool, int i) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    public void addParticipant(Car car) {
        participants.add(car);
    }

    @Override
    public String toString() {
        return String.format("Race: %s, Length: %d, Prize Pool: %d, Participants: %d",
                route, length, prizePool, participants.size());
    }
}
