package saarland.cispa.sopra.systemtests.giuliano.sense;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class MarkerGetTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(2, 2);
        builder.set(0, 1, 'A').set(1, 0, 'B');
        String brainA = generateBrain("turn right", "sense ahead marker 2 else 3", "jump 2", "jump 3");
        String brainB = generateBrain("mark 2", "sense here marker 2 else 3", "jump 2", "jump 3");
        WorldInfo w = gameInfo.simulate(4,0,builder.export(),brainA,brainB);
        //B
        checkPC(w.getAnt(0), 2);
        //A
        checkPC(w.getAnt(1),3);
    }
}
