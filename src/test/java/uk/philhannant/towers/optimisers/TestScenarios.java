package uk.philhannant.towers.optimisers;

import com.google.common.collect.ImmutableList;
import uk.philhannant.towers.model.*;

import java.util.List;

public abstract class TestScenarios {
    public static List<TestScenario> testScenarios = ImmutableList.of(
            new TestScenario(
                    new Scenario(
                            ImmutableList.of(
                                    new Transmitter(1, new Point(0, 0), 1)
                            ),
                            ImmutableList.of(
                                    new Receiver(1, new Point(0, 2))
                            )
                    ),
                    new Result(
                            ImmutableList.of(
                                    new Transmitter(1, new Point(0, 0), 2)
                            )
                    )
            ),
            new TestScenario(
                    new Scenario(
                            ImmutableList.of(
                                    new Transmitter(1, new Point(0, 0), 1),
                                    new Transmitter(2, new Point(0, 6), 2)
                            ),
                            ImmutableList.of(
                                    new Receiver(1, new Point(0, 3))
                            )
                    ),
                    new Result(
                            ImmutableList.of(
                                    new Transmitter(1, new Point(0, 0), 1),
                                    new Transmitter(2, new Point(0, 6), 3)
                            )
                    )
            ),
            new TestScenario(
                    new Scenario(
                            ImmutableList.of(
                                    new Transmitter(1, new Point(2, 4), 1),
                                    new Transmitter(2, new Point(0, 6), 3),
                                    new Transmitter(3, new Point(1, 2), 2),
                                    new Transmitter(4, new Point(3, 5), 3)
                            ),
                            ImmutableList.of(
                                    new Receiver(1, new Point(0, 1)),
                                    new Receiver(2, new Point(8, 8)),
                                    new Receiver(3, new Point(6, 5))
                            )
                    ),
                    new Result(
                            ImmutableList.of(
                                    new Transmitter(1, new Point(2, 4), 1),
                                    new Transmitter(2, new Point(0, 6), 3),
                                    new Transmitter(3, new Point(1, 2), 2),
                                    new Transmitter(4, new Point(3, 5), 5)
                            )
                    )
            ),
            new TestScenario(
                    new Scenario(
                            ImmutableList.of(
                                    new Transmitter(1, new Point(12, 12), 1),
                                    new Transmitter(2, new Point(12, 1), 1),
                                    new Transmitter(3, new Point(12, 23), 1),
                                    new Transmitter(4, new Point(1, 12), 1),
                                    new Transmitter(5, new Point(23, 12), 1)
                            ),
                            ImmutableList.of(
                                    new Receiver(1, new Point(12, 6)),
                                    new Receiver(2, new Point(6, 12)),
                                    new Receiver(3, new Point(18, 12)),
                                    new Receiver(4, new Point(12, 18))
                            )
                    ),
                    new Result(
                            ImmutableList.of(
                                    new Transmitter(1, new Point(12, 12), 6),
                                    new Transmitter(2, new Point(12, 1), 1),
                                    new Transmitter(3, new Point(12, 23), 1),
                                    new Transmitter(4, new Point(1, 12), 1),
                                    new Transmitter(5, new Point(23, 12), 1)
                            )
                    )
            ),
            new TestScenario(
                    new Scenario(
                            ImmutableList.of(
                                    new Transmitter(1, new Point(18, 23), 2),
                                    new Transmitter(2, new Point(34, 30), 4),
                                    new Transmitter(3, new Point(22, 21), 3),
                                    new Transmitter(4, new Point(13, 14), 2),
                                    new Transmitter(5, new Point(32, 27), 4),
                                    new Transmitter(6, new Point(16, 19), 3)
                            ),
                            ImmutableList.of(
                                    new Receiver(1, new Point(8, 37)),
                                    new Receiver(2, new Point(6, 27)),
                                    new Receiver(3, new Point(35, 18)),
                                    new Receiver(4, new Point(36, 8)),
                                    new Receiver(5, new Point(5, 1)),
                                    new Receiver(6, new Point(12, 22)),
                                    new Receiver(7, new Point(0, 19)),
                                    new Receiver(8, new Point(3, 16))
                            )
                    ),
                    new Result(
                            ImmutableList.of(
                                    new Transmitter(1, new Point(18, 23), 2),
                                    new Transmitter(2, new Point(34, 30), 4),
                                    new Transmitter(3, new Point(22, 21), 3),
                                    new Transmitter(4, new Point(13, 14), 2),
                                    new Transmitter(5, new Point(32, 27), 4),
                                    new Transmitter(6, new Point(16, 19), 20)
                            )
                    )
            ),
            new TestScenario(
                    new Scenario(
                            ImmutableList.of(
                                    new Transmitter(1, new Point(2, 5), 1),
                                    new Transmitter(2, new Point(0, 6), 3),
                                    new Transmitter(3, new Point(1, 2), 2),
                                    new Transmitter(4, new Point(6, 8), 1)
                            ),
                            ImmutableList.of(
                                    new Receiver(1, new Point(0, 1)),
                                    new Receiver(2, new Point(9, 8)),
                                    new Receiver(3, new Point(6, 5))
                            )
                    ),
                    new Result(
                            // you must edit this to define the correct expectedResult yourself
                            ImmutableList.of(
                                    new Transmitter(1, new Point(2, 5), 1),
                                    new Transmitter(2, new Point(0, 6), 3),
                                    new Transmitter(3, new Point(1, 2), 2),
                                    new Transmitter(4, new Point(6, 8), 3)
                            )
                    )
            ),
            new TestScenario(
                    new Scenario(
                            ImmutableList.of(
                                    new Transmitter(1, new Point(1, 6), 1),
                                    new Transmitter(2, new Point(1, 0), 1),
                                    new Transmitter(3, new Point(5, 0), 1)
                            ),
                            ImmutableList.of(
                                    new Receiver(1, new Point(1, 2)),
                                    new Receiver(2, new Point(5, 2))
                            )
                    ),
                    new Result(
                            // you must edit this to define the correct expectedResult yourself
                            ImmutableList.of(
                                    new Transmitter(1, new Point(1, 6), 1),
                                    new Transmitter(2, new Point(1, 0), 2),
                                    new Transmitter(3, new Point(5, 0), 2)
                            )
                    )
            )
    );
}
