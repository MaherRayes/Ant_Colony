package saarland.cispa.sopra.systemtests.giuliano.death;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class BorderDeathTest extends BaseTest {
    //TODO fix
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(4, 4);
        builder.set(0,0,'B').set(1,0,'B');
        builder.set(1,1,'B').set(3,1,'B');
        builder.set(0,2,'B').set(1,2,'A');
        String brainB = getEmptyBrain();
        String brainA = generateBrain("move else 0", "jump 0");
        WorldInfo w = gameInfo.simulate(1,0,builder.export(),brainA,brainB);
        checkNoAntAt(w,0,1);
        checkAntAmount(w,5);
    }
}
