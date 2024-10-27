package saarland.cispa.sopra.systemtests.simon.acolatests.sense;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.GameInfo;

public class SenseRock extends SenseTest{

    public SenseRock() {
        super('#');
    }

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String zeroPos = trivialBrain();
        String brain = createNewBrain( "sense ahead rock else 2", "jump 1", "jump 2");
        simulate(10, 42, getMapper().toString(), brain, zeroPos);

        verifyAnts(new AntTestObject(1, 1));
    }
}
