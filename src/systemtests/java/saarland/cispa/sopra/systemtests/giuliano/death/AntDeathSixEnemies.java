package saarland.cispa.sopra.systemtests.giuliano.death;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class AntDeathSixEnemies extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(6, 6);
        builder.set(1,0,'B').set(2,0,'B').set(0,1,'B').set(1,2,'B').set(2,2,'B').set(2,1,'B').set(1,1,'A');
        String brainB = getEmptyBrain();
        String brainA = generateBrain("move else 0", "jump 0");
        //Five nts
        WorldInfo w = gameInfo.simulate(1,0,builder.export(),brainA,brainB);
        checkNoAntAt(w,1,1);
        checkAntAmount(w,6);
        checkScore(w,'A',3);
        checkScore(w, 'B', 0);
    }
}
