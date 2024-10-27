package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
public class BrainNameUppercaseTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            "AB\n" +
            "#1\n";
        String brain = "brain \"Sample\" {\nturn right\njump 0\n}";
        String brainError = "brain \"sample\" {\n}";
     //   expect(IllegalArgumentException.class,()-> gameInfo.simulate(1, 42, map, brain, brain));
        expect(IllegalArgumentException.class,()-> gameInfo.simulate(1, 42, map, brainError, brain));
    }
}
