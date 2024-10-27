package saarland.cispa.sopra.systemtests.simon.acolatests.invalidbrain;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class BrainOk extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain("jump 0", "move else 4", "turn left", "sense ahead foe else 0", "pickup else 0", "drop else 4", "test 1 else 0", "mark 2", "unmark 2", "set 1", "unset 1", "direction east else 0", "jump 0"); // too big!

        simulate(100, 42, map, brain, brain);

        verifyAnt(new AntTestObject(0, 0));
        verifyAnt(new AntTestObject(1, 0));

    }
}
