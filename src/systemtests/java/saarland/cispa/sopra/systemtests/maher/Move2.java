package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Move2 extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {


        WorldInfo wi = simGame(3, gameInfo);

        boolean[] b = wi.getAnt(1).getRegister();
        if(b[1]){
            fail("The ant moved, but there is another ant in the way");
        }


    }

    private WorldInfo simGame(int round, GameInfo g) {

        String map = "2\n2\n" +
            "..\n" +
            "AB";
        String brain1 = "brain \"sample\" {\nturn left\n move else 3\n set 1 \njump 0\n}";
        String brain2 = "brain \"sample\" {\n set 1 \njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        return g.simulate(round, 42, map, brain2, brain1);

    }
}
