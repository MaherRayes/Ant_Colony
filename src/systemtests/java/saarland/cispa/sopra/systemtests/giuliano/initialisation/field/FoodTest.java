package saarland.cispa.sopra.systemtests.giuliano.initialisation.field;

import saarland.cispa.sopra.systemtests.WorldInfo;

public class FoodTest extends BaseFieldTest {
    @Override
    public void checkField(WorldInfo world, int x, int y, char expectedType) {
        if(x == 2 && y == 2) {
            checkFood(world.getFieldAt(x, y), 3);
        } else {
            checkFood(world.getFieldAt(x, y), 0);
        }
    }
}
