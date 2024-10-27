package saarland.cispa.sopra.systemtests.giuliano.movement;

import saarland.cispa.sopra.systemtests.giuliano.Direction;
import saarland.cispa.sopra.systemtests.FieldInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.giuliano.WorldGenerator;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class AutomatedMovementTest extends MovementTest {

    //TODO Currently disabled due to not working
    @Override
    protected void test(GameInfo gameInfo) {
        WorldInfo w;
        WorldGenerator g;
        FieldInfo target;
        MapBuilder builder = new MapBuilder(6, 6);
        builder.set(2, 3, 'B').set(4, 3, '#').set(2, 1, '2');
        int id = 0;
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                if(builder.get(i, j) == '.') {
                    builder.set(i, j, 'A');
                    g = getNTurnsOneMoveGenerator(gameInfo, builder.export());
                    builder.set(i, j, '.');
                    for(Direction d : Direction.getSet()) {
                        w = g.run(Direction.neededRightTurns(d));
                        if(3 < j) {
                            id = 1;
                        } else if(3 == j && 2 < i) {
                            id = 1;
                        }
                        target = calculateTarget(w, w.getFieldAt(i,j), d);
                        if(target.getX() == 2 && target.getY() == 3 || target.getX() == 4 && target.getY() == 3) {
                            target = w.getFieldAt(i,j);
                        }
                        //checkPosition(w.getAnt(id), target.getX(), target.getY());
                        checkPosition(w.getAnt(id), target.getX(), target.getY(),i,j,d.name());
                    }
                }
            }
        }
    }
}
