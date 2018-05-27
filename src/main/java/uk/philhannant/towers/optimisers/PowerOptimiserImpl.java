package uk.philhannant.towers.optimisers;

import uk.philhannant.towers.model.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type Power optimiser.
 */
public class PowerOptimiserImpl implements PowerOptimiser {


    /**
     * Constructor to instantiate a new Power optimiser.
     */
    public PowerOptimiserImpl(){

    }

    /**
     * Optimise method, first checks if the scenario needs to be optimised. If so, it creates new Result classes for
     * both a single transmitter increase and multiple transmitter power increase. Then it compares the total power
     * value or each of these results and returns the result with the lowest total power
     *
     * @param scenario the scenario
     * @return the result with the lowest power value
     */
    @Override
    public Result optimise(Scenario scenario) {
        if(getOutofRangeReceivers(scenario).isEmpty()) {
            return new Result(scenario.transmitters);
        } else {
            Result singleIncrease =  new Result(increaseTransmitters(scenario.transmitters,
                    getPossiblePowerIncrease(scenario), scenario));
            Result multipleIncrease = new Result((optimiseMultiple(scenario)));
            return singleIncrease.getTotalPower() <= multipleIncrease.getTotalPower() ? singleIncrease : multipleIncrease;
        }
    }

    /**
     * Method used to optimise multiple transmitters. Works by concatenating the original list of trasnmitters with a
     * list containing updated trasnmitters that are closest to the out of range receivers. Duplicates are removed
     * using the removeDuplicate method and the final list is returned.
     *
     * @param scenario the scenario
     * @return the list containing the updated transmitters
     */
    public List<Transmitter> optimiseMultiple(Scenario scenario){
        List<Transmitter> allTransmitters = Stream.concat(scenario.transmitters.stream(),
                getClosestTransmitters(scenario).stream()).collect(Collectors.toList());
        return removeDuplicateTransmitters(allTransmitters);
    }

    /**
     * Method uses brute force to update each transmitter one by one with the possible power values.
     * If the getOutofRangeReceivers method returns any empty list then correct power increase has been applied and
     * the new list of transmitters is returned.
     *
     * @param transmitters the transmitters
     * @param powers       the powers
     * @param scenario     the scenario
     * @return the list containing the updated transmitters
     */
    public List<Transmitter> increaseTransmitters(List<Transmitter> transmitters, List<Integer> powers, Scenario scenario){
        for(Integer p: powers){
            for(Transmitter t: transmitters){
                List<Transmitter> updatedTransmitters = new ArrayList<>(transmitters);
                updatedTransmitters.set(transmitters.indexOf(t),
                new Transmitter(t.id, t.location, t.power + p));
                if(getOutofRangeReceivers(new Scenario(updatedTransmitters, scenario.receivers)).isEmpty()){
                    return updatedTransmitters;
                }
            }
        }
        return transmitters;
    }


    /**
     * Method used to calculate the increase in power required to bring the receiver into range.
     *
     * @param transmitter the transmitter
     * @param receiver    the receiver
     * @return the int value fo the power increase
     */
    public int increasePower(Transmitter transmitter, Receiver receiver){
        if(outOfRange(transmitter, receiver)){
            return calculateChebyshev(transmitter.location, receiver.location) - transmitter.power;
        } else {
            return 0;
        }
    }


    /**
     * Boolean method used to check if a receiver is in the range of the passed in transmitter.
     *
     * @param transmitter the transmitter
     * @param receiver    the receiver
     * @return the boolean
     */
    public boolean outOfRange(Transmitter transmitter, Receiver receiver){
        return transmitter.power < calculateChebyshev(transmitter.location, receiver.location);
    }


    /**
     * Overloaded boolean method used to check if a receiver is in the range of any of the transmitters.
     *
     * @param transmitters the transmitters
     * @param receiver     the receiver
     * @return the boolean
     */
    public boolean outOfRange(List<Transmitter> transmitters, Receiver receiver){
        return transmitters.stream().allMatch(t -> outOfRange(t, receiver));
    }

    /**
     * Method to return a filtered list containing only the receivers that are out of range
     *
     * @param scenario the scenario
     * @return list containing out of range receivers
     */
    public List<Receiver> getOutofRangeReceivers(Scenario scenario){
        return scenario.receivers.stream()
                .filter(receiver -> outOfRange(scenario.transmitters, receiver))
                .collect(Collectors.toList());
    }

    /**
     * Method used to calculate the chebyshev distance.
     *
     * @param p1 the p 1
     * @param p2 the p 2
     * @return the integer
     */
    public Integer calculateChebyshev(Point p1, Point p2) {
        return Math.max(Math.abs(p1.x - p2.x), Math.abs(p1.y - p2.y));
    }


    /**
     * Method to calculate the distance a receiver is to the range of the passed in trasnmitter.
     *
     * @param transmitter the transmitter
     * @param receiver    the receiver
     * @return distance to range as an int
     */
    public int distanceToRange(Transmitter transmitter, Receiver receiver){
        return Math.abs(calculateChebyshev(transmitter.location, receiver.location) - transmitter.power);
    }


    /**
     * Overloaded method used to map the distance to range values for an out of range receiver.
     *
     * @param transmitters the transmitters
     * @param receiver     the receiver
     * @return the list containing distance to range values for the receiver
     */
    public List<Integer> distancetoRange(List<Transmitter> transmitters, Receiver receiver){
        return transmitters.stream().map(t -> distanceToRange(t, receiver)).collect(Collectors.toList());
    }


    /**
     * Method used to obtain all of the possible power increases for the passed in scenario. First the out of range
     * receivers are obtained, which are then used to obtain a list of lists containing all the possible power increases.
     * The list is flattened, sorted and duplicates removed before being returned.
     *
     * @param scenario the scenario
     * @return the list containing sorted and unique power increases
     */
    public List<Integer> getPossiblePowerIncrease(Scenario scenario){
        List<Receiver> outOfRange = getOutofRangeReceivers(scenario);
        List<List<Integer>> powers = outOfRange.stream()
                .map(r -> distancetoRange(scenario.transmitters, r))
                .collect(Collectors.toList());
        return powers.stream().flatMap(List::stream)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }


    /**
     * Method used to remove duplicate transmitters from the list passed in based on the power value. Only transmitters
     * that are not the nearest to an out of range receiver or have the highest power value are retained.
     *
     * @param transmitters the transmitters
     * @return the list containing unique values
     */
    public List<Transmitter> removeDuplicateTransmitters(List<Transmitter> transmitters){
        List<Transmitter> finalList = new ArrayList<>();
        for(Transmitter t: transmitters) {
            if (findGreatestPower(transmitters, t).isEmpty()) {
                finalList.add(t);
            } else {
                finalList.add(findGreatestPower(transmitters, t).get(0));
            }
        }
        return finalList.stream().distinct().collect(Collectors.toList());
    }

    /**
     * Method used to obtain a list of the closest trasnmitters to the out of range receivers. When found the closest
     * transmitter is updated with the required power value to bring the receiver into range.
     *
     * @param scenario the scenario
     * @return the list containing updated transmitters.
     */
    public List<Transmitter> getClosestTransmitters(Scenario scenario){
        List<Receiver> outOfRange = getOutofRangeReceivers(scenario);
        List<List<Transmitter>> closestTransmitters = outOfRange
                .stream()
                .map(r -> getClosestTransmitter(scenario.transmitters, r))
                .collect(Collectors.toList());
        List<Transmitter> finalUpdatedTransmitters = closestTransmitters.stream().flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
        finalUpdatedTransmitters = removeDuplicateTransmitters(finalUpdatedTransmitters);
        return finalUpdatedTransmitters;
    }

    /**
     *Overloaded method used to find the closest transmitter for a certain receiver and then returning a new list
     * containing the updated transmitters.
     *
     * @param transmitters the transmitters
     * @param receiver     the receiver
     * @return the list of updated transmitters
     */
    public List<Transmitter> getClosestTransmitter(List<Transmitter> transmitters, Receiver receiver){
        Integer minDistance = transmitters.stream().mapToInt(t -> distanceToRange(t, receiver))
                .min()
                .orElse(-1);
        List<Transmitter> closest = transmitters.stream()
                .filter(t -> distanceToRange(t, receiver) == minDistance)
                .distinct()
                .collect(Collectors.toList());
        List<Transmitter> updatedTransmitter = closest;
        for(Transmitter t: updatedTransmitter){
            updatedTransmitter.set(updatedTransmitter.indexOf(t),
                    new Transmitter(t.id, t.location,  t.power + distanceToRange(t, receiver)));
        }
        return updatedTransmitter;
    }

    /**
     * Method used to find the greatest power increase for a certain transmitter, before returning a list containing
     * the relevant transmitter.
     *
     * @param transmitters       the transmitters
     * @param transmitterToCheck the transmitter to check
     * @return the list
     */
    public List<Transmitter> findGreatestPower(List<Transmitter> transmitters, Transmitter transmitterToCheck){
        List<Transmitter> matchingTrasnmitters = transmitters.stream()
                .filter(t -> t.id == transmitterToCheck.id)
                .collect(Collectors.toList());
        return matchingTrasnmitters.stream()
                .filter(t -> t.power > transmitterToCheck.power)
                .distinct()
                .collect(Collectors.toList());
    }

}
