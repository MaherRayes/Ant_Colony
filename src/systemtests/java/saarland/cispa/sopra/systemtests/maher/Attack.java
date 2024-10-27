package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Attack extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {


        WorldInfo wi = simGame(1, gameInfo);

        if(wi.getAnts().size() != 5){
            fail("The surrounded ant didn't die");
        }

        if(wi.getFieldAt(1,1).getFood() != 3){
            fail("There should be 3 pieces of food where the ant died");
        }

    }

    private WorldInfo simGame(int round, GameInfo g) {

        String map = "4\n4\n" +
            ".AA.\n" +
            "A.A.\n" +
            ".AB.\n" +
            "....";
        String brain = "brain \"sample\" {\nturn left \njump 0\n}";
        String brain2 = "brain \"sample2\" {\n move else 1 \njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        return g.simulate(round, 42, map, brain, brain2);

    }
}
