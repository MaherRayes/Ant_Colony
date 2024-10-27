package saarland.cispa.sopra.systemtests.giuliano.death;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class DeathDropEnemyBase extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(6, 6);
        builder.set(1,1,'B').set(2,1,'B').set(3,2,'B').set(1,2,'B').set(1,3,'B');
        builder.set(2,2,'3');
        builder.set(2,3,'A');
        String brainA = generateBrain("move else 0", "pickup else 0", "move else 0", "jump 2");
        String brainB = generateBrain("move else 0", "jump 1");
        WorldInfo w = gameInfo.simulate(40,0,builder.export(),brainA,brainB);
        checkFood(w.getFieldAt(2,2), 2);
        checkScore(w, 'A', 0);
        checkScore(w, 'B', 4);
    }
}
