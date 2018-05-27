package uk.philhannant.towers.model;

public class Receiver extends Tower {
    public Receiver(int id, Point location) {
        super(id, location);
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "id=" + id +
                ", location=" + location +
                '}';
    }
}
