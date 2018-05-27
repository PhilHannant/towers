package uk.philhannant.towers.optimisers;

import uk.philhannant.towers.model.Result;
import uk.philhannant.towers.model.Scenario;

public class TestScenario {
    public final Scenario scenario;
    public final Result expectedResult;

    public TestScenario(Scenario scenario, Result expectedResult) {
        this.scenario = scenario;
        this.expectedResult = expectedResult;
    }
}
