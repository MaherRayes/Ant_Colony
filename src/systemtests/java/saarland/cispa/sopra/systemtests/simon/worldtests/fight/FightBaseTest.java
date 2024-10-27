package saarland.cispa.sopra.systemtests.simon.worldtests.fight;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.simon.map.Mapper;

public abstract class FightBaseTest extends BaseTest {
    public FightBaseTest() {
        super();
        // Aha! Da ist die B-Meise also umzingelt!!!
        setMapper(new Mapper(4, 4));
        getMapper().setField(1, 1, 'B');
        getMapper().setField(2, 0, 'A');
        getMapper().setField(1, 0, 'A');
        getMapper().setField(0, 1, 'A');
        getMapper().setField(1, 2, 'A');
        getMapper().setField(2, 2, 'A');

    }
}
