package saarland.cispa.sopra.systemtests.giuliano.death;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class DeathSurrendedDifferentSwarms extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(6, 6);
        builder.set(1,0,'B').set(2,0,'C').set(0,1,'D').set(1,2,'E').set(2,1,'F').set(1,1,'A');
        String brainA = generateBrain("move else 0", "jump 0");
        WorldInfo w = gameInfo.simulate(1,0,builder.export(),brainA,getEmptyBrain(),getEmptyBrain(),getEmptyBrain(),getEmptyBrain(),getEmptyBrain());
        checkNoAntAt(w,1,1);
        checkAntAmount(w,5);
        checkScore(w,'A',3);
        checkScore(w, 'B', 0);
        checkScore(w, 'C',0);
    }
}
