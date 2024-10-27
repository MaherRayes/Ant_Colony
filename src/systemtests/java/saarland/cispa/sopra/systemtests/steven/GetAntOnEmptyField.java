package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

//import java.util.NoSuchElementException;

public class GetAntOnEmptyField extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            ".A\n" +
            "B.";
        String brain = "brain \"sample\" {\nturn right\njump 0\n}";
        WorldInfo worldInfo = gameInfo.simulate(0, 42, map, brain, brain) ;
        worldInfo.getWidth();
        //expect(NoSuchElementException.class, () -> worldInfo.getFieldAt(0, 0).getAnt());
        //expect(NoSuchElementException.class, () -> worldInfo.getFieldAt(1, 1).getAnt());

    }
}
