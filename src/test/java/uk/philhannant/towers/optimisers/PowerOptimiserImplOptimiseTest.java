package uk.philhannant.towers.optimisers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static uk.philhannant.towers.optimisers.TestScenarios.testScenarios;

/**
 * Test class containing all of the test scenario optimise tests.
 */
public class PowerOptimiserImplOptimiseTest {

    private final PowerOptimiser subject = new PowerOptimiserImpl();

    /**
     * Optimise test for scenario 0.
     *
     * @throws Exception the exception
     */
    @Test
    public void testScenario0() throws Exception {
        assertEquals(testScenarios.get(0).expectedResult, subject.optimise(testScenarios.get(0).scenario));
    }

    /**
     * Optimise test for scenario 1.
     *
     * @throws Exception the exception
     */
    @Test
    public void testScenario1() throws Exception {
        assertEquals(testScenarios.get(1).expectedResult, subject.optimise(testScenarios.get(1).scenario));
    }

    /**
     * Optimise test for scenario 2.
     *
     * @throws Exception the exception
     */
    @Test
    public void testScenario2() throws Exception {
        assertEquals(testScenarios.get(2).expectedResult, subject.optimise(testScenarios.get(2).scenario));
    }

    /**
     * Optimise test for scenario 3.
     *
     * @throws Exception the exception
     */
    @Test
    public void testScenario3() throws Exception {
        assertEquals(testScenarios.get(3).expectedResult, subject.optimise(testScenarios.get(3).scenario));
    }

    /**
     * Optimise test for scenario 4.
     *
     * @throws Exception the exception
     */
    @Test
    public void testScenario4() throws Exception {
        assertEquals(testScenarios.get(4).expectedResult, subject.optimise(testScenarios.get(4).scenario));
    }

    /**
     * Optimise test for scenario 5.
     *
     * @throws Exception the exception
     */
    @Test
    public void testScenario5() throws Exception {
        assertEquals(testScenarios.get(5).expectedResult, subject.optimise(testScenarios.get(5).scenario));
    }

    /**
     * Optimise test for scenario 6.
     *
     * @throws Exception the exception
     */
    @Test
    public void testScenario6() throws Exception {
        assertEquals(testScenarios.get(6).expectedResult, subject.optimise(testScenarios.get(6).scenario));
    }
}
