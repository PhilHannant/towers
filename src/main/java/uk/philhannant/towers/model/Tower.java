package uk.philhannant.towers.model;

public abstract class Tower {
    public final int id;
    public final Point location;

    public Tower(int id, Point location) {
        this.id = id;
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tower tower = (Tower) o;

        if (id != tower.id) return false;
        return location != null ? location.equals(tower.location) : tower.location == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
}
