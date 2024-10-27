package saarland.cispa.sopra.systemtests.giuliano.initialisation.field;

import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.giuliano.Direction;
import saarland.cispa.sopra.systemtests.WorldInfo;
import saarland.cispa.sopra.systemtests.giuliano.initialisation.InitialisationTest;

import java.util.List;
import java.util.NoSuchElementException;

public class AntTest extends InitialisationTest {
    @Override
    public void run(WorldInfo world) {
        List<AntInfo> ants = world.getAnts();
        if(ants.size() != 3) {
            fail(String.format("Expected an amount of %d ants but got %d.", 3, ants.size()));
        }
        AntInfo ant;
        for(int i = 0; i < 3; i++) {
            //Check ID correctness
            ant = world.getAnt(i);
            if(ant == null) {
                fail(String.format("Ant with valid id %d was null.", i));
            }
            if(!ants.contains(ant)) {
                fail(String.format("getAnt(%d) returns ant which is not in AntList", i));
            }
            if(ant.getId() != i) {
                fail(String.format("ID attribute of ant %d has the wrong value %d.", i, ant.getId()));
            }

            //deeper Ant checks
            checkAnt(ant);
        }
        //Check ID order
        world.getFieldAt(1, 1).getAnt().ifPresent(a -> checkID(a, 0));
        world.getFieldAt(3, 3).getAnt().ifPresent(a -> checkID(a, 1));
        world.getFieldAt(4, 3).getAnt().ifPresent(a -> checkID(a, 2));

        //NoSuchElement
        expect(NoSuchElementException.class, () -> world.getAnt(42));
    }

    public void checkAnt(AntInfo ant) {
        checkDirection(ant, Direction.northwest);
        checkHasFood(ant, false);
    }
}
