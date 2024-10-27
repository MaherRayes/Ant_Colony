package saarland.cispa.sopra.systemtests.simon.worldtests.initial;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.simon.map.Mapper;

public abstract class InitStateSuper extends BaseTest {

    public InitStateSuper() {
        super();

        setMapper(new Mapper(4, 4));
        getMapper().setField(0,0, 'A');
        getMapper().setField(0,1, 'B');

        getMapper().setField(0,2, '#');
        getMapper().setField(0,3, '1');
        getMapper().setField(1,0, '2');


    }
}
