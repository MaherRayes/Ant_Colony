package saarland.cispa.sopra.systemtests.giuliano.movement;

import saarland.cispa.sopra.systemtests.giuliano.Direction;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.WorldGenerator;

public class TurnTest extends MovementTest {
    @Override
    protected void test(GameInfo gameInfo) {
        String aBrainRight = generateBrain("turn right","turn right","turn right","turn right","turn right","turn right","jump 0");
        String aBrainLeft = generateBrain("turn left","turn left","turn left","turn left","turn left","turn left","jump 0");
        WorldGenerator g = (i) -> gameInfo.simulate(i, 0, buildSimpleMap(), aBrainRight, getEmptyBrain());
        //right turns
        checkDirection(g.run(1).getAnt(0), Direction.northeast);
        checkDirection(g.run(2).getAnt(0), Direction.east);
        checkDirection(g.run(3).getAnt(0), Direction.southeast);
        checkDirection(g.run(4).getAnt(0), Direction.southwest);
        checkDirection(g.run(5).getAnt(0), Direction.west);
        checkDirection(g.run(6).getAnt(0), Direction.northwest);
        //left turns
        g = (i) -> gameInfo.simulate(i, 0, buildSimpleMap(), aBrainLeft, getEmptyBrain());
        checkDirection(g.run(1).getAnt(0), Direction.west);
        checkDirection(g.run(2).getAnt(0), Direction.southwest);
        checkDirection(g.run(3).getAnt(0), Direction.southeast);
        checkDirection(g.run(4).getAnt(0), Direction.east);
        checkDirection(g.run(5).getAnt(0), Direction.northeast);
        checkDirection(g.run(6).getAnt(0), Direction.northwest);
    }
}
