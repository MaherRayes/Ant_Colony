package saarland.cispa.sopra.systemtests.simon.worldtests.fight;

import saarland.cispa.sopra.systemtests.GameInfo;

import java.util.NoSuchElementException;

public class UmzingelMitFutterKillAufFutter extends FightBaseTest{

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        getMapper().setField(1, 1, '9');
        getMapper().setField(2, 1, '1');
        getMapper().setField(3, 1, 'B');


        String map = getMapper().toString();

        simulate(1000, 42, map, trivialBrain(), createNewBrain("turn left", "move else 5", "pickup else 5", "move else 5", "jump 4", "jump 5"));


        if(worldInfo.getFieldAt(3, 1).getAnt().isPresent()){
            fail("Ant not dead!");
        }
        if(worldInfo.getFieldAt(1, 1).getAnt().isPresent()){
            fail("Ant not dead!");
        }
        expect(NoSuchElementException.class, () -> worldInfo.getAnt(3));

        if(worldInfo.getFieldAt(2, 1).getAnt().isPresent()){
            fail("Ant not dead!");
        }

        verifyScore('A', 0);
        verifyFutterOn(1, 1, 13);
        verifyScore('B', 0);
    }

}
