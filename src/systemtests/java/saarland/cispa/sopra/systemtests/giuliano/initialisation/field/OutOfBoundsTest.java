package saarland.cispa.sopra.systemtests.giuliano.initialisation.field;

import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;

public class OutOfBoundsTest extends BaseFieldTest {

    @Override
    public void checkField(WorldInfo world, int x, int y, char expectedType) {
        expect(NoSuchElementException.class, () -> world.getFieldAt(0,-1));
        expect(NoSuchElementException.class, () -> world.getFieldAt(-1,0));
        expect(NoSuchElementException.class, () -> world.getFieldAt(6,0));
        expect(NoSuchElementException.class, () -> world.getFieldAt(0,6));
    }
}
