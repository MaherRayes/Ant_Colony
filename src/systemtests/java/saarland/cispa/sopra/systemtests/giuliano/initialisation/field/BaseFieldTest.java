package saarland.cispa.sopra.systemtests.giuliano.initialisation.field;

import saarland.cispa.sopra.systemtests.WorldInfo;
import saarland.cispa.sopra.systemtests.giuliano.initialisation.InitialisationTest;

public abstract class BaseFieldTest extends InitialisationTest {
    @Override
    public void run(WorldInfo world) {
        checkField(world, 0, 0, '.');
        checkField(world, 1, 1, 'A');
        checkField(world, 2, 2, '.');
        checkField(world, 3, 3, 'B');
        checkField(world, 4, 3, 'B');
        checkField(world, 5, 5, '.');
        checkField(world, 0, 5, '.');
        checkField(world, 5, 0, '.');
    }

    public abstract void checkField(WorldInfo world, int x, int y, char expectedType);
}
