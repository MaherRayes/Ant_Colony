package saarland.cispa.sopra.systemtests.giuliano.food;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class FoodMuchFoodTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(4,4);
        builder.set(1,2,'A').set(2,2,'B');
        builder.set(0,1,'1').set(0,0,'9');
        String brainA = generateBrain("move else 0", "pickup else 0", "move else 0", "drop else 0", "jump 4");
        WorldInfo w = gameInfo.simulate(40,0,builder.export(),brainA,getEmptyBrain());
        checkFood(w.getFieldAt(0,0), 10);
    }
}
