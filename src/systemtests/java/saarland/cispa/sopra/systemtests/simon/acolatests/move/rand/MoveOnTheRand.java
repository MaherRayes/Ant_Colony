package saarland.cispa.sopra.systemtests.simon.acolatests.move.rand;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.GameInfo;

public class MoveOnTheRand extends MoveOnTheRandBaseTest {

//    public void testosteronMit(int startX, int startY, String[] turns, int endX, int endY){

//    }

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);


        String map = getMapper().toString();
        String brain = createNewBrain(  "move else 2", "jump 1", "jump 2");

        simulate(50, 42, map, brain, trivialBrain());

        // initial direction: northwest
        verifyAnts(new AntTestObject(0, 3, 3,  1, "northwest"));
        verifyAnts(new AntTestObject(1, 1, 1,  "northwest"));
        verifyNoMoreAnts();

    }
}
