package homeworks.homework06Dop;

import java.util.Objects;

public class Channel {
    private String name;
    private int number;
    private Program program;

    public Channel(String name, int number, Program program) {
        this.name = name;
        this.number = number;
        this.program = program;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public Program getProgram() {
        return program;
    }

    @Override
    public String toString() {
        return "Канал: " + name + " (Номер: " + number + ", Программа: " + program + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return number == channel.number && Objects.equals(name, channel.name) && Objects.equals(program, channel.program);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, program);
    }
}
