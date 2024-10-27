package saarland.cispa.sopra.systemtests.giuliano.movement;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class MoveOnFoodTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(2,2).set(0,0, '4').set(0,1,'A').set(1,1,'B');
        String brainA = generateBrain("move else 1", "jump 1");
        WorldInfo w = gameInfo.simulate(1,0,builder.export(),brainA,getEmptyBrain());
        checkPosition(w.getAnt(0),0,0);
    }
}
