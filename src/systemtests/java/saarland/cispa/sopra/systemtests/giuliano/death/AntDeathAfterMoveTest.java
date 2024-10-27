package saarland.cispa.sopra.systemtests.giuliano.death;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class AntDeathAfterMoveTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(6, 6);
        builder.set(1,1,'B').set(2,1,'B');
        builder.set(1,2,'B').set(3,2,'B');
        builder.set(1,3,'B').set(2,3,'A');
        String brainB = getEmptyBrain();
        String brainA = generateBrain("move else 0", "jump 0");
        //Five nts
        WorldInfo w = gameInfo.simulate(1,0,builder.export(),brainA,brainB);
        checkNoAntAt(w,2,2);
        checkAntAmount(w,5);
    }
}
