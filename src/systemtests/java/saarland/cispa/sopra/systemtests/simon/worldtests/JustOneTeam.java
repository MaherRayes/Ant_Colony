package saarland.cispa.sopra.systemtests.simon.worldtests;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.simon.BaseTest;

public class JustOneTeam extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        getMapper().setField(1, 0, '.');

        String brain = createNewBrain( "jump 0");

        expect(IllegalArgumentException.class, () -> simulate(1, 42, getMapper().toString(), brain));

    }
}
