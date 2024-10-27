package saarland.cispa.sopra.systemtests.simon.worldtests.initial;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.simon.map.Mapper;

import java.util.NoSuchElementException;

public class InitalStatesFails extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        setMapper(new Mapper(4, 4));
        getMapper().setField(0,0, 'A');
        getMapper().setField(0,1, 'B');

        expect(NoSuchElementException.class, () -> worldInfo.getAnt(2));
        expect(NoSuchElementException.class, () -> worldInfo.getFieldAt(4, 0));
        expect(NoSuchElementException.class, () -> worldInfo.getFieldAt(0, 4));

        if( worldInfo.getFieldAt(0, 0).getMarkers().get('C') != null) {
            fail("Other team marker is not null");
        }

    }
}
