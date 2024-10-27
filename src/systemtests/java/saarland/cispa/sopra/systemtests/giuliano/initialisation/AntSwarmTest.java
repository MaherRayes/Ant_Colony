package saarland.cispa.sopra.systemtests.giuliano.initialisation;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class AntSwarmTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(2,2);
        builder.set(0,0, 'C').set(1,0,'A').set(0,1,'D').set(1,1,'B');
        WorldInfo w = gameInfo.simulate(0,0,builder.export(),getEmptyBrain(),getEmptyBrain(),getEmptyBrain(),getEmptyBrain());
        checkSwarm(w.getAnt(0),'C');
        checkSwarm(w.getAnt(1),'A');
        checkSwarm(w.getAnt(2),'D');
        checkSwarm(w.getAnt(3),'B');
    }
}
