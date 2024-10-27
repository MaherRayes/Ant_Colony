package saarland.cispa.sopra.systemtests.simon.acolatests.sense;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.GameInfo;

public class SenseMarker1SOPRAKANNWOHLKEINEDOPPELTENKLASSENDASISTABERSCHADE extends SenseTest{

    // TODO currently commented out. What is up here?

    public SenseMarker1SOPRAKANNWOHLKEINEDOPPELTENKLASSENDASISTABERSCHADE() {
        super('.');
    }

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        String brain = createNewBrain( "mark 0", "sense here marker 0 else 3", "jump 2", "jump 3");
        String brain2 =createNewBrain( "mark 1", "sense here marker 0 else 3", "jump 2", "jump 3");

        simulate(10, 42, getMapper().toString(), brain, brain2);

        verifyAnts(new AntTestObject(0, 3));
        verifyAnts(new AntTestObject(1, 2));
    }
}
