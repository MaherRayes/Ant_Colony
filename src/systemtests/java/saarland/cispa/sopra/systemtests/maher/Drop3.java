package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Drop3 extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {


        WorldInfo wi = simGame(50, gameInfo);

        if(wi.getScore('A')!= 1){
            fail("A should have a point");
        }



    }

    private WorldInfo simGame(int round, GameInfo g) {

        String map = "4\n4\n" +
            "1A..\n" +
            "B...\n"+
            "....\n" +
            "....";
        String brain = "brain \"sample\" {\n move else 1\njump 1\n}";
        String brain2 = "brain \"sample2\" {\nmove else 1\n pickup else 2\n turn right \n turn right\n move else 1\n drop else 1 \njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        return g.simulate(round, 42, map, brain, brain2);

    }
}
