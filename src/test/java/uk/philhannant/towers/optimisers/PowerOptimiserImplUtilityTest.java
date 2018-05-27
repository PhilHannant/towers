package uk.philhannant.towers.optimisers;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import uk.philhannant.towers.model.Point;
import uk.philhannant.towers.model.Receiver;
import uk.philhannant.towers.model.Transmitter;

import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Test class for extra methods added to the PowerOptimiserImpl class.
 */
public class PowerOptimiserImplUtilityTest {

    private PowerOptimiserImpl powerOptimiserImpl = new PowerOptimiserImpl();


    /**
     * Test to calculate chebyshev distance.
     */
    @Test
    public void calculateChebyshevTest(){
        Point transmitter = new Point(0,0);
        Point receiver = new Point(0,2);
        Integer expectedResult = 2;
        Integer actualResult = powerOptimiserImpl.calculateChebyshev(transmitter, receiver);
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Test to check boolean method for checking if a receiver is out of range.
     */
    @Test
    public void outOfRangeTest(){
        assertEquals(true, powerOptimiserImpl.outOfRange(TestScenarios.testScenarios.get(0).scenario.transmitters.get(0),
                TestScenarios.testScenarios.get(0).scenario.receivers.get(0)));

    }

    /**
     * Increase power test.
     *
     */
    @Test
    public void increasePowerTest(){
        assertEquals(1, powerOptimiserImpl.increasePower(TestScenarios.testScenarios.get(0).scenario.transmitters.get(0),
                TestScenarios.testScenarios.get(0).scenario.receivers.get(0)));
    }

    /**
     * Test for scenario 0 to get out of range recievers.
     *
     */
    @Test
    public void testScenario0GetOutofRangeRecievers(){
        List<Receiver> expected = ImmutableList.of(
                new Receiver(1, new Point(0, 2))
        );
        assertEquals(expected, powerOptimiserImpl.getOutofRangeReceivers(TestScenarios.testScenarios.get(0).scenario));
    }

    /**
     * Test for scenario 1 to get out of range recievers.
     *
     */
    @Test
    public void testScenario1GetOutofRangeRecievers(){
        List<Receiver> expected = ImmutableList.of(
                new Receiver(1, new Point(0, 3))
        );
        assertEquals(expected, powerOptimiserImpl.getOutofRangeReceivers(TestScenarios.testScenarios.get(1).scenario));
    }


    /**
     * Test for scenario 2 to get out of range recievers.
     */
    @Test
    public void testScenario2GetOutofRangeRecievers(){
        List<Receiver> expected = ImmutableList.of(
                new Receiver(2, new Point(8, 8))
        );
        assertEquals(expected, powerOptimiserImpl.getOutofRangeReceivers(TestScenarios.testScenarios.get(2).scenario));
    }

    /**
     * Test for scenario 3 to get out of range recievers.
     */
    @Test
    public void testScenario3GetOutofRangeRecievers(){
        List<Receiver> expected = ImmutableList.of(
                new Receiver(1, new Point(12, 6)),
                new Receiver(2, new Point(6, 12)),
                new Receiver(3, new Point(18, 12)),
                new Receiver(4, new Point(12, 18))
        );
        assertEquals(expected, powerOptimiserImpl.getOutofRangeReceivers(TestScenarios.testScenarios.get(3).scenario));
    }

    /**
     * Test for scenario 4 to get out of range recievers.
     */
    @Test
    public void testScenario4GetOutofRangeRecievers(){
        List<Receiver> expected = ImmutableList.of(
                new Receiver(1, new Point(8, 37)),
                new Receiver(2, new Point(6, 27)),
                new Receiver(3, new Point(35, 18)),
                new Receiver(4, new Point(36, 8)),
                new Receiver(5, new Point(5, 1)),
                new Receiver(6, new Point(12, 22)),
                new Receiver(7, new Point(0, 19)),
                new Receiver(8, new Point(3, 16))
        );
        assertEquals(expected, powerOptimiserImpl.getOutofRangeReceivers(TestScenarios.testScenarios.get(4).scenario));
    }

    /**
     * Test for scenario 5 to get out of range recievers.
     */
    @Test
    public void testScenario5GetOutofRangeRecievers(){
        List<Receiver> expected = ImmutableList.of(
                new Receiver(2, new Point(9, 8)),
                new Receiver(3, new Point(6, 5))
        );
        assertEquals(expected, powerOptimiserImpl.getOutofRangeReceivers(TestScenarios.testScenarios.get(5).scenario));
    }

    /**
     * Test for scenario 6 to get out of range recievers.
     */
    @Test
    public void testScenario6GetOutofRangeRecievers(){
        List<Receiver> expected = ImmutableList.of(
                new Receiver(1, new Point(1, 2)),
                new Receiver(2, new Point(5, 2))
        );
        assertEquals(expected, powerOptimiserImpl.getOutofRangeReceivers(TestScenarios.testScenarios.get(6).scenario));
    }

    /**
     * Test to check distance to the range of a transmitter is returning correct value.
     */
    @Test
    public void getDistanceToRangeTest(){
        assertEquals(2,
                powerOptimiserImpl.distanceToRange(TestScenarios.testScenarios.get(2).scenario.transmitters.get(3),
                        TestScenarios.testScenarios.get(2).scenario.receivers.get(1)));
    }

    /**
     * Test to get all possible power increases for scenario 0.
     */
    @Test
    public void testScenario0GetPossiblePower(){
        assertEquals(ImmutableList.of(1), powerOptimiserImpl.getPossiblePowerIncrease(TestScenarios.testScenarios.get(0).scenario));
    }

    /**
     * Test to get all possible power increases for scenario 0.
     */
    @Test
    public void testScenario1GetPossiblePower(){
        assertEquals(ImmutableList.of(1,2), powerOptimiserImpl.getPossiblePowerIncrease(TestScenarios.testScenarios.get(1).scenario));
    }

    /**
     * Test to get all possible power increases for scenario 0.
     */
    @Test
    public void testScenario2GetPossiblePower(){
        assertEquals(ImmutableList.of(2, 5), powerOptimiserImpl.getPossiblePowerIncrease(TestScenarios.testScenarios.get(2).scenario));
    }

    /**
     * Test to get all possible power increases for scenario 0.
     */
    @Test
    public void testScenario3GetPossiblePower(){
        assertEquals(ImmutableList.of(4, 5, 10, 16), powerOptimiserImpl.getPossiblePowerIncrease(TestScenarios.testScenarios.get(3).scenario));
    }

    /**
     * Test to get all possible power increases for scenario 0.
     */
    @Test
    public void testScenario4GetPossiblePower(){
        assertEquals(ImmutableList.of(1, 4, 5, 6, 7, 8, 10, 11, 12, 13, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 27, 28, 30),
                powerOptimiserImpl.getPossiblePowerIncrease(TestScenarios.testScenarios.get(4).scenario));
    }

    /**
     * Test to get all possible power increases for scenario 0.
     */
    @Test
    public void testScenario5GetPossiblePower(){
        assertEquals(ImmutableList.of(2, 3, 6), powerOptimiserImpl.getPossiblePowerIncrease(TestScenarios.testScenarios.get(5).scenario));
    }

    /**
     * Test to get all possible power increases for scenario 0.
     */
    @Test
    public void testScenario6GetPossiblePower(){
        assertEquals(ImmutableList.of(1, 3), powerOptimiserImpl.getPossiblePowerIncrease(TestScenarios.testScenarios.get(6).scenario));
    }

    /**
     * Test to check increaseTransmitters method is returning a list containing a transmitter with a power increase for scenario 1.
     */
    @Test
    public void testScenario1IncreaseTransmittersTest(){
        List<Transmitter> expected = ImmutableList.of(
                new Transmitter(1, new Point(0, 0), 1),
                new Transmitter(2, new Point(0, 6), 3)
        );
        assertEquals(expected,
                powerOptimiserImpl.increaseTransmitters(TestScenarios.testScenarios.get(1).scenario.transmitters,
                    powerOptimiserImpl.getPossiblePowerIncrease(TestScenarios.testScenarios.get(1).scenario),
                        TestScenarios.testScenarios.get(1).scenario));
    }

    /**
     * Test to check increaseTransmitters method is returning a list containing a transmitter with a power increase for scenario 2.
     */
    @Test
    public void testScenario2IncreaseTransmittersTest(){
        List<Transmitter> expected = ImmutableList.of(
                new Transmitter(1, new Point(2, 4), 1),
                new Transmitter(2, new Point(0, 6), 3),
                new Transmitter(3, new Point(1, 2), 2),
                new Transmitter(4, new Point(3, 5), 5)
        );
        assertEquals(expected,
                powerOptimiserImpl.increaseTransmitters(TestScenarios.testScenarios.get(2).scenario.transmitters,
                        powerOptimiserImpl.getPossiblePowerIncrease(TestScenarios.testScenarios.get(2).scenario),
                        TestScenarios.testScenarios.get(2).scenario));
    }

    /**
     * Test to check increaseTransmitters method is returning a list containing a transmitter with a power increase for scenario 3.
     */
    @Test
    public void testScenario3IncreaseTransmittersTest(){
        List<Transmitter> expected = ImmutableList.of(
                new Transmitter(1, new Point(12, 12), 6),
                new Transmitter(2, new Point(12, 1), 1),
                new Transmitter(3, new Point(12, 23), 1),
                new Transmitter(4, new Point(1, 12), 1),
                new Transmitter(5, new Point(23, 12), 1)
        );
        assertEquals(expected,
                        powerOptimiserImpl.increaseTransmitters(TestScenarios.testScenarios.get(3).scenario.transmitters,
                            powerOptimiserImpl.getPossiblePowerIncrease(TestScenarios.testScenarios.get(3).scenario),
                                TestScenarios.testScenarios.get(3).scenario));
    }

    /**
     * Test to check increaseTransmitters method is returning a list containing a transmitter with a power increase for scenario 4.
     */
    @Test
    public void testScenario4IncreaseTransmittersTest(){
        List<Transmitter> expected = ImmutableList.of(
                new Transmitter(1, new Point(18, 23), 2),
                new Transmitter(2, new Point(34, 30), 4),
                new Transmitter(3, new Point(22, 21), 3),
                new Transmitter(4, new Point(13, 14), 2),
                new Transmitter(5, new Point(32, 27), 4),
                new Transmitter(6, new Point(16, 19), 20)
        );
        assertEquals(expected,
                powerOptimiserImpl.increaseTransmitters(TestScenarios.testScenarios.get(4).scenario.transmitters,
                        powerOptimiserImpl.getPossiblePowerIncrease(TestScenarios.testScenarios.get(4).scenario),
                        TestScenarios.testScenarios.get(4).scenario));
    }

    /**
     * Test to check increaseTransmitters method is returning a list containing a transmitter with a power increase for scenario 5.
     */
    @Test
    public void testScenario5IncreaseTransmittersTest(){
        List<Transmitter> expected = ImmutableList.of(
                new Transmitter(1, new Point(2, 5), 1),
                new Transmitter(2, new Point(0, 6), 3),
                new Transmitter(3, new Point(1, 2), 2),
                new Transmitter(4, new Point(6, 8), 3)
        );
        assertEquals(expected,
                powerOptimiserImpl.increaseTransmitters(TestScenarios.testScenarios.get(5).scenario.transmitters,
                        powerOptimiserImpl.getPossiblePowerIncrease(TestScenarios.testScenarios.get(5).scenario),
                        TestScenarios.testScenarios.get(5).scenario));
    }

    /**
     * Test to check increaseTransmitters method is returning a list containing a transmitter with a power increase for scenario 6.
     */
    @Test
    public void testScenario6IncreaseTransmittersTest(){
        List<Transmitter> expected = ImmutableList.of(
                new Transmitter(1, new Point(1, 6), 4),
                new Transmitter(2, new Point(1, 0), 1),
                new Transmitter(3, new Point(5, 0), 1)
        );
        assertEquals(expected,
                powerOptimiserImpl.increaseTransmitters(TestScenarios.testScenarios.get(6).scenario.transmitters,
                        powerOptimiserImpl.getPossiblePowerIncrease(TestScenarios.testScenarios.get(6).scenario),
                        TestScenarios.testScenarios.get(6).scenario));
    }

    //add remove duplicate test

    /**
     * Test to check getClosestTransmitters is returning a list containing transmitters with updated power values.
     */
    @Test
    public void getUpdatedTransmitterTest(){
        List<Transmitter> expected = ImmutableList.of(
                new Transmitter(2, new Point(1, 0), 2),
                new Transmitter(3, new Point(5, 0), 2)
        );
        assertEquals(expected, powerOptimiserImpl.getClosestTransmitters(TestScenarios.testScenarios.get(6).scenario));
    }
}
