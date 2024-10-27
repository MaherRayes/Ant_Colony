package saarland.cispa.sopra.systemtests.simon.worldtests.fight;

import saarland.cispa.sopra.systemtests.GameInfo;

public class UmzingelAmStart extends FightBaseTest{

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        getMapper().setField(3, 3, 'C');

        String map = getMapper().toString();

        simulate(1, 42, map, trivialBrain(), trivialBrain(), createNewBrain("move else 1", "jump 1"));

        if(worldInfo.getFieldAt(1, 1).getAnt().isPresent()){
            fail("Ant not dead!");
        }
        verifyFutterOn(1, 1, 0);
        verifyScore('B', 3);
        verifyScore('A', 0);
        verifyScore('C', 0);
    }

}
