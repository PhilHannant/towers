package uk.philhannant.towers.model;

import java.util.List;

public class Scenario {
    public final List<Transmitter> transmitters;
    public final List<Receiver> receivers;

    public Scenario(List<Transmitter> transmitters, List<Receiver> receivers) {
        this.transmitters = transmitters;
        this.receivers = receivers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Scenario scenario = (Scenario) o;

        if (transmitters != null ? !transmitters.equals(scenario.transmitters) : scenario.transmitters != null)
            return false;
        return receivers != null ? receivers.equals(scenario.receivers) : scenario.receivers == null;
    }

    @Override
    public int hashCode() {
        int result = transmitters != null ? transmitters.hashCode() : 0;
        result = 31 * result + (receivers != null ? receivers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Scenario{" +
                "transmitters=" + transmitters +
                ", receivers=" + receivers +
                '}';
    }
}
