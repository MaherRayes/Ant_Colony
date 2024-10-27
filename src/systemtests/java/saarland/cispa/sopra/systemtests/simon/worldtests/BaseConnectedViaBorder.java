package saarland.cispa.sopra.systemtests.simon.worldtests;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.simon.map.Mapper;

public class BaseConnectedViaBorder extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        setMapper(new Mapper(4,4 ));
        getMapper().setField(0, 0, 'A');
        getMapper().setField(3, 3, 'A');
        getMapper().setField(2, 2, 'B');

        String map = getMapper().toString();

        simulate(1, 42, map, trivialBrain(), trivialBrain());

        // initial direction: northwest
        verifyAnts(new AntTestObject(0, 0, 0, 0, "northwest"));
        verifyAnts(new AntTestObject(1, 2, 2, 0, "northwest"));
        verifyAnts(new AntTestObject(2, 3, 3, 0, "northwest"));
        verifyNoMoreAnts();
        if (worldInfo.getAnt(0).getSwarm() != 'A') {
            fail("hard1");
        }
        if (worldInfo.getAnt(1).getSwarm() != 'B') {
            fail("hard2");
        }
        if (worldInfo.getAnt(2).getSwarm() != 'A') {
            fail("hard3");
        }

    }
}
