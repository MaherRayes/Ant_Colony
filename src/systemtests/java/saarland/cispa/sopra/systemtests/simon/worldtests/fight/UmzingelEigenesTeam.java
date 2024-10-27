package saarland.cispa.sopra.systemtests.simon.worldtests.fight;

import saarland.cispa.sopra.systemtests.GameInfo;

public class UmzingelEigenesTeam extends FightBaseTest{

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        getMapper().setField(1, 1, 'A');

        getMapper().setField(3, 3, 'B');

        String map = getMapper().toString();

        simulate(1, 42, map, trivialBrain(), createNewBrain("move else 1", "jump 1"));

        if(!worldInfo.getFieldAt(1, 1).getAnt().isPresent()){
            fail("Ant dead!");
        }
        verifyFutterOn(1, 1, 0);
        verifyScore('B', 0);
        verifyScore('A', 0);
    }

}
