package saarland.cispa.sopra.systemtests.giuliano.food;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class FoodDropBaseTest extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(2,2);
        builder.set(0,0,'3').set(0,1,'A').set(1,1,'B');
        String brainA = generateBrain("move else 0", "pickup else 0", "move else 0","move else 0","move else 0", "drop else 0", "jump 6");
        String  brainB = generateBrain("move else 0","move else 0","move else 0","move else 0","move else 0","jump 5");
        WorldInfo w = gameInfo.simulate(100, 0, builder.export(),brainA,brainB);
        checkScore(w,'A',1);
        checkScore(w,'B',0);
        checkFood(w.getFieldAt(0,1), 0);
        checkHasFood(w.getAnt(0), false);
    }
}
