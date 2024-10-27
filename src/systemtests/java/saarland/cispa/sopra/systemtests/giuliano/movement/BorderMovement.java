package saarland.cispa.sopra.systemtests.giuliano.movement;

import saarland.cispa.sopra.systemtests.giuliano.Direction;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.giuliano.WorldGenerator;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class BorderMovement extends MovementTest {
    @Override
    protected void test(GameInfo gameInfo) {
        //Initial at (1,0)
        String map = buildCustomMap('b', 'f');
        WorldGenerator g = getNTurnsOneMoveGenerator(gameInfo, map);
        WorldInfo w = g.run(Direction.neededRightTurns(Direction.northwest));
        checkPosition(w.getAnt(0), 0, 3);
        w = g.run(Direction.neededRightTurns(Direction.northeast));
        checkPosition(w.getAnt(0), 1, 3);
        //Initial at (2,3)
        MapBuilder builder = new MapBuilder(4,4);
        builder.set(2,3,'A').set(3,3,'B');
        g = getNTurnsOneMoveGenerator(gameInfo, builder.export());
        w = g.run(Direction.neededRightTurns(Direction.southwest));
        checkPosition(w.getAnt(0),2,0);
        w = g.run(Direction.neededRightTurns(Direction.southeast));
        checkPosition(w.getAnt(0),3,0);
        //initial(0,0)
        builder = new MapBuilder(4,4);
        builder.set(3,3,'.');
        builder.set(0,0,'A').set(1,1,'B');
        g = getNTurnsOneMoveGenerator(gameInfo, builder.export());
        w = g.run(Direction.neededRightTurns(Direction.northwest));
        checkPosition(w.getAnt(0),3,3);
        w = g.run(Direction.neededRightTurns(Direction.southeast));
        checkPosition(w.getAnt(0),0,1);
        //initial(3,0)
        builder.set(1,1,'.');
        builder.set(3,0,'A').set(3,2,'B');
        g = getNTurnsOneMoveGenerator(gameInfo,builder.export());
        w = g.run(Direction.neededRightTurns(Direction.northeast));
        checkPosition(w.getAnt(0), 0,3);
        w = g.run(Direction.neededRightTurns(Direction.northwest));
        checkPosition(w.getAnt(0),3,3);
        /*
        w = g.run(Direction.neededRightTurns(Direction.southwest));
        checkPosition(w.getAnt(0),2,1);
        w = g.run(Direction.neededRightTurns(Direction.southeast));
        checkPosition(w.getAnt(0), 3,1);
        */
    }
}
