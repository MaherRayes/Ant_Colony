package saarland.cispa.sopra.systemtests.giuliano.elsetests;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class DirectionElseTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(2,2);
        builder.set(0,0,'A').set(0,1,'B');
        String brainA = generateBrain("turn left", "direction northwest else 2", "jump 1", "jump 2");
        WorldInfo w = gameInfo.simulate(4,0,builder.export(),brainA,getEmptyBrain());
        checkPC(w.getAnt(0),2);
    }
}
