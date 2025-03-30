package model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter

public class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    public Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    public void addParticipant(Car car) {
        participants.add(car);
    }

    public List<Car> getParticipants() {
        return participants;
    }

    @Override
    public String toString() {
        return String.format("Race: %s, Length: %d, Prize Pool: %d, Participants: %d",
                route, length, prizePool, participants.size());
    }
}