package saarland.cispa.sopra.systemtests.simon.worldtests.fight;

import saarland.cispa.sopra.systemtests.GameInfo;

public class UmzingelVerschiedeneTeams extends FightBaseTest{

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        getMapper().setField(1, 1, 'B');
        getMapper().setField(2, 0, 'A');
        getMapper().setField(1, 0, 'C');
        getMapper().setField(0, 1, 'D');
        getMapper().setField(1, 2, 'E');
        getMapper().setField(2, 2, 'F');
        getMapper().setField(3, 3, 'G');

        String map = getMapper().toString();

        simulate(1, 42, map, trivialBrain(), trivialBrain(), trivialBrain(), trivialBrain(), trivialBrain(), trivialBrain(), createNewBrain("move else 1", "jump 1"));

        if(worldInfo.getFieldAt(1, 1).getAnt().isPresent()){
            fail("Ant not dead!");
        }
        verifyFutterOn(1, 1, 0);
        verifyScore('C', 0);
        verifyScore('D', 0);
        verifyScore('B', 3);
        verifyScore('E', 0);
        verifyScore('A', 0);
    }

}
