package saarland.cispa.sopra.systemtests.giuliano.resttime;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class OtherResttimes extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(2,2).set(0,0, 'A').set(1,1,'#').set(1,0,'B');
        String[] brainA = {brainShortcut("sense ahead food else 0"), brainShortcut("move else 0"), brainShortcut("pickup else 0"), brainShortcut("jump 0"), brainShortcut("flip 3 else 0"), brainShortcut("turn left"), brainShortcut("turn right"), brainShortcut("drop else 0"), brainShortcut("mark 0"), brainShortcut("unmark 0"), brainShortcut("set 0"), brainShortcut("unset 0"), brainShortcut("test 0 else 0"), brainShortcut("direction east else 0")};
        WorldInfo w;
        for(String brain : brainA) {
            w = gameInfo.simulate(1,0,builder.export(),brain,getEmptyBrain());
            checkRestTime(w.getAnt(0),0);
        }
    }

    //generated brain with jump on end
    public String brainShortcut(String cmd) {
        return generateBrain(cmd, "jump 1");
    }
}
