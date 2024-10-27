package saarland.cispa.sopra.systemtests.simon.acolatests.move;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.simon.map.Mapper;

public abstract  class MoveBaseTest extends BaseTest {

    public MoveBaseTest() {
        super();
        setMapper(new Mapper(4, 4));
        getMapper().setField(1, 1, 'A');
        getMapper().setField(2, 2, 'B');
    }
}
