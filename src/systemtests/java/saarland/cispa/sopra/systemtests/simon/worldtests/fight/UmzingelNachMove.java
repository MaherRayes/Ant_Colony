package saarland.cispa.sopra.systemtests.simon.worldtests.fight;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.simon.map.Mapper;

public class UmzingelNachMove extends FightBaseTest{

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        setMapper(new Mapper(4, 4));
        getMapper().setField(1, 0, '#');
        getMapper().setField(0, 0, '#');
        getMapper().setField(0, 1, '#');
        getMapper().setField(1, 2, 'A');
        getMapper().setField(1, 1, 'A');
        getMapper().setField(1, 3, 'A');
        getMapper().setField(2, 3, 'A');

        getMapper().setField(3, 3, 'A');
        getMapper().setField(2, 2, 'B');


        String map = getMapper().toString();

        simulate(1, 42, map, createNewBrain("move else 1", "jump 1"), trivialBrain());

        if(worldInfo.getFieldAt(2, 2).getAnt().isPresent()){
            fail("Ant isch ned tot!");
        }
        verifyFutterOn(2, 2, 0);

    }

}
