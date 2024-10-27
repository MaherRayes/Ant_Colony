package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;


public class FaultyMapOneSwarm extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            ".A\n" +
            "..";
        String brain = "brain \"sample\" {\nturn right\njump 0\n}";
        expect(IllegalArgumentException.class, () ->gameInfo.simulate(0, 42, map,  brain)) ;
        expect(IllegalArgumentException.class, () ->gameInfo.simulate(0, 42, map,  brain, brain)) ;


    }
}
