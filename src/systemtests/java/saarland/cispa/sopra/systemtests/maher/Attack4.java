package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Attack4 extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {


        WorldInfo wi = simGame(1, gameInfo);

        if(wi.getAnts().size() != 5){
            fail("No ant died");
        }

        if(wi.getFieldAt(1,1).getFood() != 0){
            fail("There should be no food cause the ant didn't die");
        }

    }

    private WorldInfo simGame(int round, GameInfo g) {

        String map = "4\n4\n" +
            ".#..\n" +
            "ABA.\n" +
            ".AA.\n" +
            "....";
        String brain = "brain \"sample\" {\nturn left \njump 0\n}";
        String brain2 = "brain \"sample2\" {\nmove else 1 \njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        return g.simulate(round, 42, map, brain, brain2);

    }
}
