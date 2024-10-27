package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Attack6 extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {


        WorldInfo wi = simGame(39, gameInfo);

        if(wi.getFieldAt(1,1).getFood() != 4){
            fail("After the ant died, The food should have dropped on the field");
        }

    }

    private WorldInfo simGame(int round, GameInfo g) {

        String map = "4\n4\n" +
            ".AA.\n" +
            "A.A.\n" +
            ".A1.\n" +
            "..B.";
        String brain = "brain \"sample\" {\nturn left \njump 0\n}";
        String brain2 = "brain \"sample2\" {\n move else 1\n pickup else 2\n move else 3 \njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        return g.simulate(round, 42, map, brain, brain2);

    }
}
