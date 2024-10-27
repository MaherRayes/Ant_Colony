package saarland.cispa.sopra.systemtests.giuliano.initialisation.field;

import saarland.cispa.sopra.systemtests.WorldInfo;

public class TypeTest extends BaseFieldTest {
    @Override
    public void checkField(WorldInfo world, int x, int y, char expectedType) {

        char c = world.getFieldAt(x, y).getType();
        if(c != expectedType) {
            fail(String.format("Field (%d,%d) was of type %c but should be %c.", x, y, c, expectedType));

        }
    }
}
