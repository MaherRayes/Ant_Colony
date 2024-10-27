package saarland.cispa.sopra.systemtests.simon.acolatests.marker;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class SenseForeignMarker extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
       setGameInfo(gameInfo);

        String map = getMapper().toString();
        String brain = createNewBrain( "mark 1", "jump 1");
        String brainOther = createNewBrain( "jump 1", "sense left marker 1 else 3", "jump 2", "jump 3");


        simulate(10, 42, map, brain, brainOther);

        // initial direction: northwest
        verifyAnt(new AntTestObject(0, 1));
        verifyAnt(new AntTestObject(1, 3));

        // TODO verifyMarker(0, 0, 'A', false, true, false, false, false, false, false);
      //  verifyMarker(0, 0, 'B', false, false, false, false, false, false, false);

    }
}
