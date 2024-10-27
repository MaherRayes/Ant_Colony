package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Drop extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {


        WorldInfo wi = simGame(19, gameInfo);

        boolean[] b = wi.getAnt(0).getRegister();
        boolean[] b2 = wi.getAnt(1).getRegister();
        if(!b[1]||wi.getAnt(0).hasFood() || wi.getFieldAt(0,0).getFood() != 1){
            fail("The ant picked the food up then droped it, there should be no jumping in the code and the ant shouldn't have any food");
        }
        if(b2[1]){
            fail("The ant didn't pick any food up, there should be jumping in the code");
        }


    }

    private WorldInfo simGame(int round, GameInfo g) {

        String map = "2\n2\n" +
            "1A\n" +
            ".B";
        String brain = "brain \"sample\" {\nturn left\n move else 3\n pickup else 0 \n drop else 0 \n set 1 \njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        return g.simulate(round, 42, map, brain, brain);

    }
}
