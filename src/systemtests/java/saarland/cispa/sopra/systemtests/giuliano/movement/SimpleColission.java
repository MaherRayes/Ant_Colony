package saarland.cispa.sopra.systemtests.giuliano.movement;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class SimpleColission extends MovementTest {

    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(4,4);
        builder.set(1,0, '#').set(1,1,'A').set(2,2, 'B');
        String northWest = generateBrain("move else 0", "jump 1");
        WorldInfo w = gameInfo.simulate(1,0,builder.export(), northWest,northWest);
        checkPosition(w.getAnt(0), 1,1);
        checkPosition(w.getAnt(1), 2,2);

        builder.set(1,0,'2');
        w = gameInfo.simulate(1,0,builder.export(), northWest,northWest);
        checkPosition(w.getAnt(0), 1,0);
        checkPosition(w.getAnt(1), 1,1);

        String southEast = generateBrain("turn right","turn right","turn right","move else 0", "jump 4");
        w = gameInfo.simulate(4,0,builder.export(),southEast,southEast);
        checkPosition(w.getAnt(0), 1,1);
        checkPosition(w.getAnt(1), 2,3);
    }
}
