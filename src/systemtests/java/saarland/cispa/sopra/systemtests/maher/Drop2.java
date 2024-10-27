package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Drop2 extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {


        WorldInfo wi = simGame(36, gameInfo);

        boolean[] b = wi.getAnt(0).getRegister();
        if(!b[1]){
            fail("The ant picked and dropped the piece without problems");
        }
        if(wi.getScore('A') != 1){
            fail("The ant dropped a piece in the base, the score should be 1");
        }



    }

    private WorldInfo simGame(int round, GameInfo g) {

        String map = "4\n4\n" +
            "1A..\n" +
            "9...\n"+
            "....\n" +
            "...B";
        String brain = "brain \"sample\" {\nturn left\n move else 3\n pickup else 0 \n turn left\n turn left\n turn left\n move else 0\n drop else 9 \n set 1 \njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        return g.simulate(round, 42, map, brain, brain);

    }
}
