package saarland.cispa.sopra.systemtests.giuliano.death;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class DeathDropTest extends BaseTest {
    //TODO Currently disabled
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(6, 6);
        builder.set(1,0,'2');
        builder.set(1,1,'A').set(2,1,'B');
        builder.set(1,2,'B').set(3,2,'B');
        builder.set(1,3,'B').set(2,3,'B');
        String brainA = generateBrain("move else 0", "pickup else 0", "jump 2");
        String brainB = generateBrain("mark 0","mark 0","mark 0","mark 0","mark 0","mark 0","mark 0","mark 0","mark 0","mark 0","mark 0","mark 0","mark 0","mark 0","mark 0","mark 0","mark 0","move else 0", "move else 0", "jump 0");

        WorldInfo w = gameInfo.simulate(60,0,builder.export(),brainA,brainB);
        checkFood(w.getFieldAt(1,0),5);
    }
}
