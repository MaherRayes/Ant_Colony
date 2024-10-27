package saarland.cispa.sopra.systemtests.giuliano.initialisation.field;

import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.Optional;

public class FieldAntTest extends BaseFieldTest {
    @Override
    public void checkField(WorldInfo world, int x, int y, char expectedType) {
        Optional<AntInfo> antOpt = world.getFieldAt(x, y).getAnt();
        char c = world.getFieldAt(x,y).getType();
        if(c >= 'A' && c <= 'Z') {
            antOpt.ifPresentOrElse(ant -> {
                if(ant.getSwarm() != c) {
                    fail(String.format("Field (%d,%d) has an ant of swarm %c despite its a base field of sward %c.", x, y, ant.getSwarm(), c));
                }
                if(!world.getAnts().contains(ant)) {
                    fail(String.format("Ant list doesent contain ant %d positioned on field (%d,%d).", ant.getId(), x, y));
                }
                if(ant.getField().getX() != x || ant.getField().getY() != y) {
                    fail(String.format("Field (%d,%d) has an ant which thinks it is on field (%d,%d).", x, y, ant.getField().getX(), ant.getField().getY()));
                }
            }, () -> fail(String.format("Field (%d,%d) of type %c dont has an ant depite its a base field.", x, y, c)));
        } else if(antOpt.isPresent()) {
            fail(String.format("Field (%d,%d) of type %c has an ant depite its not a base field.", x, y, c));
        }
    }
}
