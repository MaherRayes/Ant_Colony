package saarland.cispa.sopra.systemtests.simon.acolatests.vars;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class VarTestSimple extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain( "set 1", "test 1 else 3", "jump 2", "jump 3");
        String brainTwo = createNewBrain( "set 1", "unset 1", "test 1 else 4", "jump 3", "jump 4");

        simulate(10, 42, map, brain, brainTwo);

        verifyAnts(new AntTestObject(0, 2).withCheckRegisters(false, true, false, false, false, false));
        verifyAnts(new AntTestObject(1, 4).withCheckRegisters(false, false, false, false, false, false));

    }
}
