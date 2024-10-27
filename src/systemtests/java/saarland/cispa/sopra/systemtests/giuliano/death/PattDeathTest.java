package saarland.cispa.sopra.systemtests.giuliano.death;

import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class PattDeathTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(6,6);
        builder.setEverything('#');
        builder.set(1,0,'A').set(2,0,'A').set(0,1,'A').set(2,1,'A').set(1,2,'A');
        builder.set(1,1,'B').set(0,2,'B').set(2,2,'B').set(0,3,'B').set(1,3,'B');
        String brain = generateBrain("turn right", "turn right", "move else 3", "jump 3");
        WorldInfo w = gameInfo.simulate(3,0,builder.export(),brain,brain);
        //checkNoAntAt(w,1,1);
        int a = 0;
        int b = 0;
        for(AntInfo ant : w.getAnts()) {
            if(ant.getSwarm() == 'A') {
                a++;
            } else {
                b++;
            }
        }
        if(a != 5 || b != 4) {
            fail(String.format("Expected %d ants of A (got %d) and %d ants of B (got %d).", 5,a,4,b));
        }
    }
}
