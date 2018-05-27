package uk.philhannant.towers.optimisers;

import uk.philhannant.towers.model.Result;
import uk.philhannant.towers.model.Scenario;

/**
 * The interface Power optimiser.
 */
public interface PowerOptimiser {
    /**
     * Optimise result.
     *
     * @param scenario the scenario
     * @return the result
     */
    Result optimise(Scenario scenario);
}
