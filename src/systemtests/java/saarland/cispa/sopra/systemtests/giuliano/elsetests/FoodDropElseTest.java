package saarland.cispa.sopra.systemtests.giuliano.elsetests;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class FoodDropElseTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(2,2);
        builder.set(0,0,'3').set(0,1,'A').set(1,1,'B');
        String brainA = generateBrain("move else 0", "drop else 3", "jump 2", "jump 3");
        WorldInfo w = gameInfo.simulate(20,0,builder.export(),brainA,getEmptyBrain());
        checkPC(w.getAnt(0),3);
    }
}
