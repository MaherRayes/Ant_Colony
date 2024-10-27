package saarland.cispa.sopra.systemtests.simon.acolatests.sense;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.simon.map.Mapper;

public abstract class SenseTest extends BaseTest {

    public SenseTest(char toSet) {
        super();
        setMapper(new Mapper(4, 4));
        getMapper().setField(1, 1, toSet);
        getMapper().setField(2, 2, 'A');
        getMapper().setField(1, 0, 'B');
    }
}
