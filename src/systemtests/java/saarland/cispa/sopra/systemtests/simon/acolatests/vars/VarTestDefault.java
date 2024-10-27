package saarland.cispa.sopra.systemtests.simon.acolatests.vars;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class VarTestDefault extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain( "test 1 else 2", "jump 1", "jump 2");
        String brainTwo = createNewBrain(  "test 0 else 2", "jump 1", "jump 2");

        simulate(10, 42, map, brain, brainTwo);

        verifyAnts(new AntTestObject(0, 2).withCheckRegisters(false, false, false, false, false, false));
        verifyAnts(new AntTestObject(1, 2).withCheckRegisters(false, false, false, false, false, false));

    }
}
