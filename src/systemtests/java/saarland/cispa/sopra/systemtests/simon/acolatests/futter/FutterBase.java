package saarland.cispa.sopra.systemtests.simon.acolatests.futter;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.simon.map.Mapper;

public abstract class FutterBase extends BaseTest {


    public FutterBase() {
        super();
        setMapper(new Mapper(4, 4));
        getMapper().setField(1, 0, '1');
        getMapper().setField(1, 1, 'A');
        getMapper().setField(2, 2, 'B');
    }

}
