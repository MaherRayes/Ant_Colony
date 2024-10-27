package saarland.cispa.sopra.systemtests.giuliano.death;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class DeathBaseKeepTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(6,6);
        builder.setEverything('#');
        builder.set(1,1,'B');
        String brain = generateBrain("turn right", "turn right", "turn right", "move else 4", "sense ahead foehome else 6", "jump 5", "jump 6");
        builder.set(1,0,'A').set(2,0,'A').set(0,1,'A').set(2,1,'A').set(1,2,'A');
        WorldInfo w = gameInfo.simulate(30,0,builder.export(),brain, getEmptyBrain());
        checkPC(w.getAnt(0),5);
    }
}
