package saarland.cispa.sopra.systemtests.simon.acolatests.vars;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class VarTestOOB extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain( "test 6 else 2", "jump 1", "jump 2");
        String brainTwo = createNewBrain(  "test 5 else 2", "jump 1", "jump 2");

        expect(IllegalArgumentException.class, () -> simulate(10, 42, map, brain, brainTwo));


    }
}
