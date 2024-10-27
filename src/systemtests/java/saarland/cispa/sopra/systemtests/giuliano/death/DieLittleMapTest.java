package saarland.cispa.sopra.systemtests.giuliano.death;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class DieLittleMapTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(2,2);
        builder.set(0,0,'A').set(0,1,'B').set(1,0,'B').set(1,1,'B');
        String brainA = generateBrain("move else 0", "jump 0");
        WorldInfo w = gameInfo.simulate(1,0,builder.export(),brainA,getEmptyBrain());
        checkNoAntAt(w,0,0);
    }
}
