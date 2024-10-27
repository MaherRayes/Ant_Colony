package saarland.cispa.sopra.systemtests.simon.acolatests.move.rand;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.simon.acolatests.move.MoveBaseTest;
import saarland.cispa.sopra.systemtests.simon.map.Mapper;

public class MoveOnTheRand2 extends MoveBaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        setMapper(new Mapper(4,4));
        getMapper().setField(0,2,'A');
        getMapper().setField(0,0,'B');

        String map = getMapper().toString();
        String brain = createNewBrain( "move else 2", "jump 1", "jump 2");
        String trivial = trivialBrain();

        simulate(1, 42, map, brain, trivial);

        // initial direction: northwest
        verifyAnts(new AntTestObject(1, 3, 1,  1, "northwest").withCheckRestTime(13));
        verifyAnts(new AntTestObject(0, 0, 0,  "northwest").withCheckRestTime(0).withCheckFood(false).withCheckRegisters(false, false, false, false, false, false));
        //verifyNoMoreAnts();

    }
}
