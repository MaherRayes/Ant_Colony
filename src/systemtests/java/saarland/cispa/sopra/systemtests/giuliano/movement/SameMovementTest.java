package saarland.cispa.sopra.systemtests.giuliano.movement;

import saarland.cispa.sopra.systemtests.giuliano.Direction;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class SameMovementTest extends MovementTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(4, 4);
        builder.set(0, 0, 'B');
        builder.set(1, 2, 'A').set(2, 2, 'A');
        String brainA = generateBrain("turn right", "move else 2", "jump 2");
        WorldInfo w = gameInfo.simulate(1, 0, builder.export(), brainA, getEmptyBrain());
        w.getFieldAt(1, 2).getAnt().ifPresentOrElse(ant -> checkDirection(ant, Direction.northeast), () -> fail("no ant found"));
        w.getFieldAt(2, 2).getAnt().ifPresentOrElse(ant -> checkDirection(ant, Direction.northeast), () -> fail("no ant found"));
        w = gameInfo.simulate(2, 0, builder.export(), brainA, getEmptyBrain());
        if(!w.getFieldAt(1, 1).getAnt().isPresent()) {
            fail("no ant found");
        }
        if(!w.getFieldAt(2, 1).getAnt().isPresent()) {
            fail("no ant found");
        }
    }
}
