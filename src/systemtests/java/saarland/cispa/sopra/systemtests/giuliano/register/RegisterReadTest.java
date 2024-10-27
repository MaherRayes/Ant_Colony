package saarland.cispa.sopra.systemtests.giuliano.register;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class RegisterReadTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(2,2);
        builder.set(0,1,'A').set(1,1,'B');
        String brainA = generateBrain("test 4 else 2", "move else 2", "jump 2");
        String brainB = generateBrain("set 4", "test 4 else 3", "move else 3", "jump 3");
        WorldInfo w = gameInfo.simulate(4,0,builder.export(),brainA,brainB);
        checkPosition(w.getAnt(0),0,1);
        checkPosition(w.getAnt(1),1,0);
    }
}
