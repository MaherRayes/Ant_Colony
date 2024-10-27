package saarland.cispa.sopra.systemtests.simon.worldtests;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.simon.map.Mapper;

public class OddSize extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        setMapper(new Mapper(3, 3));

        String brain = createNewBrain( "jump 0");

        expect(IllegalArgumentException.class, () -> simulate(1, 42, new Mapper(3,3).setField(0, 0, 'A').setField(1, 0, 'B').toString(), brain, brain));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, new Mapper(0,0).toString(), brain, brain));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, new Mapper(2,2).setField(0, 0, 'A').setField(0, 0, 'B').toString(), brain, brain));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, new Mapper(2,2).setField(0, 0, '.').setField(0, 0, '.').toString(), brain, brain));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, new Mapper(2,2).setField(0, 0, 'B').setField(0, 0, 'C').toString(), brain, brain));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, new Mapper(4,4).setField(0, 0, 'A').setField(0, 0, 'C').toString(), brain, brain));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, new Mapper(3,2).setField(0, 0, 'A').setField(0, 0, 'C').toString(), brain, brain));
        expect(IllegalArgumentException.class, () -> simulate(1, 42, new Mapper(2,3).setField(0, 0, 'A').setField(0, 0, 'C').toString(), brain, brain));

        // initial direction: northwest
    }
}
