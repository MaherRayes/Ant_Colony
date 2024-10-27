package saarland.cispa.sopra.systemtests.giuliano.food;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class FoodInvalidDropTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(2,2);
        builder.set(0,0,'A').set(0,1,'B');
        String brainA = generateBrain("drop else 2", "jump 1", "jump 2");
        WorldInfo w = gameInfo.simulate(1,0,builder.export(),brainA,getEmptyBrain());
        checkScore(w, 'A', 0);
        checkHasFood(w.getAnt(0), false);
        checkPC(w.getAnt(0), 2);
    }
}
