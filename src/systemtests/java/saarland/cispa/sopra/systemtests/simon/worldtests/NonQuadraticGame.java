package saarland.cispa.sopra.systemtests.simon.worldtests;

import saarland.cispa.sopra.systemtests.simon.AntTestObject;
import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.simon.map.Mapper;

import java.util.NoSuchElementException;

public class NonQuadraticGame extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        setMapper(new Mapper(2, 4));

        getMapper().setField(0, 0, 'A');
        getMapper().setField(0, 2, '#');
        getMapper().setField(1, 0, '2');
        getMapper().setField(0, 3, '1');
        getMapper().setField(0, 1, 'B');

        // TODO checkFullMap();
        simulate(0, 42, getMapper().toString(), trivialBrain(), trivialBrain());



    }

    public void checkAnt() {
        verifyAnt(new AntTestObject(1, 0, 1, 0, "northwest"));
        verifyAnt(new AntTestObject(0, 0, 0, 0, "northwest"));
        verifyNoMoreAnts();

    }

    public void checkEx() {

        expect(NoSuchElementException.class, () -> worldInfo.getFieldAt(2, 0));
        expect(NoSuchElementException.class, () -> worldInfo.getAnt(2));
        expect(NoSuchElementException.class, () -> worldInfo.getFieldAt(0, 4));
    }

    public void checkScore() {

        verifyScore('B', 0);
        verifyScore('A', 0);

    }

    public void checkFutter() {

        verifyFutterOn(0, 3, 1);
        verifyFutterOn(1, 0, 2);
        verifyFutterOn(0, 0, 0);
    }

    public void checkMapper() {

        verifyMapper(getMapper());
    }
    public void checkMarker(){
        verifyMarker(0, 0, 'A', false, false, false, false, false, false, false);
        verifyMarker(0, 0, 'B', false, false, false, false, false, false, false);

    }
}
