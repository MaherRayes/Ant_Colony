package saarland.cispa.sopra.systemtests.giuliano.resttime;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class MoveRestTime extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(2,2).set(0,0,'A').set(1,0,'B');
        String brainA = generateBrain("move else 0","move else 1", "jump 2");
        WorldInfo w = gameInfo.simulate(1,0,builder.export(),brainA,getEmptyBrain());
        checkRestTime(w.getAnt(0), 13);
        w = gameInfo.simulate(2,0,builder.export(),brainA,getEmptyBrain());
        checkRestTime(w.getAnt(0),12);
        checkPosition(w.getAnt(0),1,1);
        w = gameInfo.simulate(14,0,builder.export(),brainA,getEmptyBrain());
        checkRestTime(w.getAnt(0),0);
        checkPosition(w.getAnt(0),1,1);

    }
}
