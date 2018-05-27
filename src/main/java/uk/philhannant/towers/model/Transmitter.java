package uk.philhannant.towers.model;

public class Transmitter extends Tower {
    public final int power;

    public Transmitter(int id, Point location, int power) {
        super(id, location);
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Transmitter that = (Transmitter) o;

        return power == that.power;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + power;
        return result;
    }

    @Override
    public String toString() {
        return "Transmitter{" +
                "power=" + power +
                ", id=" + id +
                ", location=" + location +
                '}';
    }
}
