package saarland.cispa.sopra.systemtests.simon.worldtests.fight;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.simon.map.Mapper;

public class UmzingelZweiRinge extends FightBaseTest{

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        setMapper(new Mapper(4,4));
        getMapper().setField(1,0, 'A');
        getMapper().setField(2,0, 'A');
        getMapper().setField(0,1, 'A');
        getMapper().setField(1,2, 'A');
        getMapper().setField(2,2, 'A');

        getMapper().setField(1, 1, 'B');
        getMapper().setField(2, 1, 'B');
        getMapper().setField(3, 2, 'B');
        getMapper().setField(2, 3, 'B');
        getMapper().setField(1, 3, 'B');

        getMapper().setField(3, 3, 'C');


        String map = getMapper().toString();

        simulate(1, 42, map, trivialBrain(),trivialBrain(), createNewBrain("move else 1", "jump 1"));


        if(!worldInfo.getFieldAt(2, 2).getAnt().isPresent()){
            fail("wrong Ant dead!");
        }

        if(worldInfo.getFieldAt(1, 1).getAnt().isPresent()){
            fail("Ant not dead!");
        }

        verifyScore('A', 0);
        verifyFutterOn(2, 2, 0);
        verifyScore('B', 3);
        verifyScore('C', 0);
        verifyFutterOn(1, 1, 0);


    }

}
