package saarland.cispa.sopra.systemtests.giuliano.movement;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.WorldGenerator;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class SimpleMovement extends MovementTest {
    @Override
    protected void test(GameInfo gameInfo) {
        WorldGenerator g = getNTurnsOneMoveGenerator(gameInfo, buildSimpleMap());
        WorldInfo world;
        //northwest
        world = g.run(0);
        checkPosition(world.getAnt(0), 1, 0);
        //northeast
        world = g.run(1);
        checkPosition(world.getAnt(0), 2, 0);
        //east;
        world = g.run(2);
        checkPosition(world.getAnt(0), 2, 1);
        //southeast
        world = g.run(3);
        checkPosition(world.getAnt(0), 2, 2);
        //southwest
        world = g.run(4);
        checkPosition(world.getAnt(0), 1, 2);
        world = g.run(5);
        checkPosition(world.getAnt(0), 0, 1);
    }
}
