package saarland.cispa.sopra.systemtests.simon.acolatests.move;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.simon.map.Mapper;

public class MoveTestSimpleTimeoutMoveOnce extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        setMapper(new Mapper(4, 4));
        getMapper().setField(3, 3, 'B');
        getMapper().setField(2, 2, 'A');

        String map = getMapper().toString();
        String brain = createNewBrain( "move else 3", "move else 3", "jump 2", "jump 3");
        String trivial = trivialBrain();

        // komisch?
        simulate(14, 42, map, brain, trivial);

        // initial direction: northwest
        verifyAnts(new AntTestObject(0, 1, 1,  "northwest"));
        verifyAnts(new AntTestObject(1, 3, 3,  "northwest"));
        verifyNoMoreAnts();

    }
}
