package saarland.cispa.sopra.systemtests.simon.worldtests;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class TeamNamesNonSucceding extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        getMapper().setField(2, 0, 'D');


        String brain = createNewBrain( "jump 0");

        expect(Exception.class, () -> simulate(1, 42, getMapper().toString(), brain, brain));

    }
}
