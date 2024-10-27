package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;


public class FaultyParametersSimulate extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            ".A\n" +
            "B.";
        String brain = "brain \"sample\" {\nturn right\njump 0\n}";
       // expect(IllegalArgumentException.class, () ->gameInfo.simulate(1, 42, map, null, brain) );
      //  expect(IllegalArgumentException.class, () ->gameInfo.simulate(1, 42, map, brain, null) );
        expect(IllegalArgumentException.class, () ->gameInfo.simulate(-1, 42, map, brain, brain) );
        expect(IllegalArgumentException.class, () ->gameInfo.simulate(-1, -1, map, brain, brain) );
        try {
        	gameInfo.simulate(0, 42, map, brain, brain) ;
        }catch(IllegalArgumentException e) {
        	fail("Simulator does not accept 0 as round number!");
        }
    }
}
