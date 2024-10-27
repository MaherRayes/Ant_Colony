package saarland.cispa.sopra.systemtests.simon.acolatests.vars;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class VarTestBorder extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain( "set 0", "test 0 else 3", "jump 2", "jump 3");
        String brainTwo = createNewBrain( "set 5", "test 5 else 3", "jump 2", "jump 3");

        simulate(10, 42, map, brain, brainTwo);

        verifyAnts(new AntTestObject(0, 2).withCheckRegisters(true, false, false, false, false, false));
        verifyAnts(new AntTestObject(1, 2).withCheckRegisters(false, false, false, false, false, true));

    }
}
