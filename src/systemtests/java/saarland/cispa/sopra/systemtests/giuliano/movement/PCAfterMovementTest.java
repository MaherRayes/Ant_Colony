package saarland.cispa.sopra.systemtests.giuliano.movement;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class PCAfterMovementTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(2,2);
        builder.set(0,1,'A').set(1,1,'B');
        String brain = generateBrain("move else 0", "jump 1");
        WorldInfo w = gameInfo.simulate(1,0,builder.export(),brain,brain);
        checkPC(w.getAnt(0),1);
        builder.set(0,0,'#');
        brain = generateBrain("move else 2", "jump 1","jump 2");
        w = gameInfo.simulate(1,0,builder.export(),brain,brain);
        checkPC(w.getAnt(0),2);
    }
}
