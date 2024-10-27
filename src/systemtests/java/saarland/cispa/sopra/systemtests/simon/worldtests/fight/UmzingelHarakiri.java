package saarland.cispa.sopra.systemtests.simon.worldtests.fight;

import saarland.cispa.sopra.systemtests.GameInfo;

public class UmzingelHarakiri extends FightBaseTest{

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        getMapper().setField(2, 1, 'A');
        getMapper().setField(2, 2, 'B');
        getMapper().setField(1, 1, '.');

        String map = getMapper().toString();

        simulate(1, 42, map, trivialBrain(), createNewBrain("move else 1", "jump 1"));

        if(worldInfo.getFieldAt(1, 1).getAnt().isPresent()){
            fail("Ant isch ned tot!");
        }
        verifyFutterOn(1, 1, 3);
    }

}
