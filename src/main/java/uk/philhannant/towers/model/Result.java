package uk.philhannant.towers.model;

import java.util.List;

public class Result {
    public final List<Transmitter> transmitters;

    public Result(List<Transmitter> transmitters) {

        this.transmitters = transmitters;
    }

    public int getTotalPower() {

        return transmitters.stream().map(t -> t.power).mapToInt(Integer::intValue).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        return transmitters != null ? transmitters.equals(result.transmitters) : result.transmitters == null;
    }

    @Override
    public int hashCode() {

        return transmitters != null ? transmitters.hashCode() : 0;
    }


    @Override
    public String toString() {
        return "Result{" +
                "transmitters=" + transmitters +
                '}';
    }
}
