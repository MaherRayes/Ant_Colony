package saarland.cispa.sopra.systemtests.simon.acolatests.sense;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.GameInfo;

public class SenseFoe extends SenseTest{

    public SenseFoe() {
        super('B');
    }

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String zeroPos = trivialBrain();
        String brain = createNewBrain( "sense ahead foe else 2", "jump 1", "jump 2");
        simulate(10, 42, getMapper().toString(), brain, zeroPos);

        verifyAnts(new AntTestObject(2, 1));
    }
}
