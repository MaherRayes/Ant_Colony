package saarland.cispa.sopra.systemtests.giuliano.sense;

import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.Map;

public class MarkerSetTest extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        MapBuilder builder = new MapBuilder(2,2);
        builder.set(0,0,'A').set(0,1,'B');
        String brainA = generateBrain("mark 3", "unmark 3", "jump 2");
        WorldInfo w = gameInfo.simulate(1,0,builder.export(),brainA,getEmptyBrain());
        Map<Character, boolean[]> markers = w.getFieldAt(0,0).getMarkers();
        boolean[] b;
        for(char c : markers.keySet()) {
            b = markers.get(c);
            for(int i = 0; i < b.length; i++) {
                if(c == 'A') {
                    if(i == 3) {
                        if(!b[i]) {
                            fail("a");
                        }
                    }else {
                        if(b[i]) {
                            fail("b");
                        }
                    }
                }
                else {
                    if(b[i]) {
                        fail("c");
                    }
                }
            }
        }

        markers = w.getFieldAt(0,1).getMarkers();
        for(boolean[] bools : markers.values()) {
            for(boolean bo : bools) {
                if(bo) {
                    fail("d");
                }
            }
        }

        w = gameInfo.simulate(2,0,builder.export(),brainA,getEmptyBrain());
        markers = w.getFieldAt(0,0).getMarkers();
        for(boolean[] bools : markers.values()) {
            for(boolean bo : bools) {
                if(bo) {
                    fail("e");
                }
            }
        }
    }
}
