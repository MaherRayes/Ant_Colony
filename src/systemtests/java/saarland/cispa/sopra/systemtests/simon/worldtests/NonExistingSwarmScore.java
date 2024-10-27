package saarland.cispa.sopra.systemtests.simon.worldtests;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class NonExistingSwarmScore extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);
        String brain = createNewBrain( "jump 0");

        simulate(1, 42, getMapper().toString(), brain, brain);

        expect(Exception.class, () -> getWorldInfo().getScore('C'));
    }
}
