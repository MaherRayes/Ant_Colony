package saarland.cispa.sopra.systemtests.giuliano.sense;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class SenseFoeAhead extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(2,2);
        builder.set(0,0,'B').set(0,1,'A');
        String brain = generateBrain("move else 0", "sense ahead foe else 3", "jump 2", "jump 3");
        WorldInfo w = gameInfo.simulate(20,0,builder.export(),brain,brain);
        //A
        checkPC(w.getAnt(1), 2);
        //B
        checkPC(w.getAnt(0), 3);
    }
}
