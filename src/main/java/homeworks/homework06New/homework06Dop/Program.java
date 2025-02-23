package homeworks.homework06Dop;

import java.util.Objects;

public class Program {
    private String name;
    private double rating;
    private int viewers;

    public Program(String name, double rating, int viewers) {
        this.name = name;
        this.rating = rating;
        this.viewers = viewers;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public int getViewers() {
        return viewers;
    }

    @Override
    public String toString() {
        return "Программа: " + name + " (Рейтинг: " + rating + ", Зрители: " + viewers + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return Double.compare(program.rating, rating) == 0 && viewers == program.viewers && Objects.equals(name, program.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rating, viewers);
    }
}
