package saarland.cispa.sopra.systemtests.simon.acolatests.move.rand;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.simon.map.Mapper;

public abstract  class MoveOnTheRandBaseTest extends BaseTest {

    public MoveOnTheRandBaseTest() {
        super();

        setMapper(new Mapper(4, 4));
        getMapper().setField(0, 0, 'A');
        getMapper().setField(1, 1, 'B');

    }
}
