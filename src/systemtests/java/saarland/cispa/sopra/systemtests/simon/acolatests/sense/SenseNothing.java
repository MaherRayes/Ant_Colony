package saarland.cispa.sopra.systemtests.simon.acolatests.sense;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.GameInfo;

public class SenseNothing extends SenseTest{

    public SenseNothing() {
        super('.');
    }

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String zeroPos = trivialBrain();
        String brain = createNewBrain( "sense ahead friend else 2", "jump 10", "sense ahead foe else 4", "jump 10",
            "sense ahead rock else 6", "jump 10", "sense ahead home else 8", "jump 10", "sense ahead foehome else 11", "jump 10", "jump 10", "jump 11");

        simulate(50, 42, getMapper().toString(), brain, zeroPos);

        verifyAnts(new AntTestObject(1, 11));
    }
}
