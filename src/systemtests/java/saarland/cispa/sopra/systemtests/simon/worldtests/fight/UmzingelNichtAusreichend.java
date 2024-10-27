package saarland.cispa.sopra.systemtests.simon.worldtests.fight;

import saarland.cispa.sopra.systemtests.GameInfo;

public class UmzingelNichtAusreichend extends FightBaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        getMapper().setField(2, 2, '.');
        getMapper().setField(3, 3, 'C');


        simulate(1, 42, getMapper().toString(), trivialBrain(), trivialBrain(), createNewBrain("move else 1", "jump 1"));

        if (!worldInfo.getFieldAt(1, 1).getAnt().isPresent()) {
            fail("Ant dead!");
        }
        verifyFutterOn(1, 1, 0);
        verifyScore('B', 0);
        verifyScore('A', 0);
        verifyScore('C', 0);
    }

}
