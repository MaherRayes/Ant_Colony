package saarland.cispa.sopra.systemtests.simon.worldtests;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.simon.map.Mapper;

public class BigGameField extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        setMapper(new Mapper(128, 128));
        getMapper().setField(0, 0, 'A');
        getMapper().setField(1, 0, 'B');

        simulate(1, 42, getMapper().toString(), trivialBrain(), trivialBrain());

        verifyMapper(getMapper());

    }
}
