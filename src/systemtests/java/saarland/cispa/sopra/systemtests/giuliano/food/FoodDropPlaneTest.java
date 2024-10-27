package saarland.cispa.sopra.systemtests.giuliano.food;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class FoodDropPlaneTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(2,2);
        builder.set(0,0,'3').set(0,1,'A').set(1,1,'B');
        String brainA = generateBrain("move else 0", "pickup else 0", "pickup else 4", "jump 3", "jump 4");
        WorldInfo w = gameInfo.simulate(20,0,builder.export(),brainA,getEmptyBrain());
        checkFood(w.getFieldAt(0,0),2);
        checkHasFood(w.getAnt(0), true);
        checkPC(w.getAnt(0), 4);
    }
}
