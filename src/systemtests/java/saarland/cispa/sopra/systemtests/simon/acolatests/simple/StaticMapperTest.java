package saarland.cispa.sopra.systemtests.simon.acolatests.simple;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class StaticMapperTest extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain( "jump 0");

        simulate(1, 42, map, brain, brain);

        verifyMapper(getMapper());
    }
}
