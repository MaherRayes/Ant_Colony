package saarland.cispa.sopra.systemtests.simon.worldtests.fight;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.simon.map.Mapper;

public class UmzingelKlein extends FightBaseTest{

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        setMapper(new Mapper(2, 2));
        getMapper().setField(0, 0, 'A');
        getMapper().setField(1, 0, 'A');
        getMapper().setField(0, 1, 'A');
        getMapper().setField(1, 1, 'B');

        String map = getMapper().toString();

        simulate(1, 42, map, trivialBrain(), createNewBrain("move else 1", "jump 1"));

        if(worldInfo.getFieldAt(1, 1).getAnt().isPresent()){
            fail("Ant not dead!");
        }
        verifyFutterOn(1, 1, 0);
        verifyScore('B', 3);
        verifyScore('A', 0);
    }

}
