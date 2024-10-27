package saarland.cispa.sopra.systemtests.maher;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;

public class Attack7 extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {


        WorldInfo wi = simGame(14, gameInfo);

        try{
            wi.getAnt(5);
        }catch(NoSuchElementException e){
            fail("The second ant shouldn't be dead cause the first died first");
        }

        expect(NoSuchElementException.class, () -> wi.getAnt(4));

    }

    private WorldInfo simGame(int round, GameInfo g) {

        String map = "4\n4\n" +
            ".BBA\n" +
            "BCBA\n" +
            ".BAA\n" +
            "....";
        String brain = "brain \"sample\" {\nturn left \njump 0\n}";
        String brain2 = "brain \"sample2\" {\n move else 1 \njump 0\n}";
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        return g.simulate(round, 42, map, brain, brain, brain2);

    }
}
