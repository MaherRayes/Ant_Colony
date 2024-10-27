package saarland.cispa.sopra.systemtests.maher;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Mark extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            ".A\n" +
            "B.\n";
        String brain = "brain \"ant1\" {\nmark 1\n mark 2\n turn left\n move else 0\n jump 0\n}";
        String brain2 = "brain \"ant2\" {\nmark 1\n mark 2\n jump 3\n turn right\n move else 1\n unmark 1\n jump 0\n}";

        WorldInfo world = gameInfo.simulate(0, 42, map, brain,brain2);


        boolean[] b = world.getFieldAt(1,0).getMarkers().get('A');

        for(int i = 0; i<7; i++) {
            if (b[i]) {
                fail("Mark already exists on the intial field");
            }
        }

        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        WorldInfo world2 = gameInfo.simulate(1, 42, map, brain,brain2);

        boolean[] b2 = world2.getFieldAt(1,0).getMarkers().get('A');

        if(!b2[1]) {
            fail("Added a mark but couldn't detect it");
        }

        WorldInfo world3 = gameInfo.simulate(2, 42, map, brain,brain2);

        boolean[] b3 = world3.getFieldAt(1,0).getMarkers().get('A');

        if(!b3[2] || !b3[1]) {
            fail("Added a another mark but couldn't detect it");
        }

        WorldInfo world4 = gameInfo.simulate(20, 42, map, brain,brain2);

        boolean[] b4 = world4.getFieldAt(1,0).getMarkers().get('A');

        if(!b4[2] || !b4[1]) {
            fail("unmark shouldn't work on the marks of another ant");
        }



    }
}
