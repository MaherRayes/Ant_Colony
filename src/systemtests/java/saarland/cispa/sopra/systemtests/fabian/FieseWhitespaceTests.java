package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.GameInfo;

public class FieseWhitespaceTests extends BaseTest {
    @Override
    protected void test(GameInfo gameInfo) {
        //Related whitespace characters without Unicode character property "WSpace=Y"
        String map = getCheapMap();
        String brain = getUselessBrain();
        String brain1 = "brain \"weisserSpacer\"{" +
            "jump᠎0\n" +
            "}";
        String brain2 = "brain \"weisserSpacer\"{" +
            "jump\u200B0\n" +
            "}";
        String brain3 = "brain \"weisserSpacer\"{" +
            "jump\u200C0\n" +
            "}";
        String brain4 = "brain \"weisserSpacer\"{" +
            "jump\u200D0\n" +
            "}";
        String brain5 = "brain \"weisserSpacer\"{" +
            "jump\u20600\n" +
            "}";
        String brain6 = "brain \"weisserSpacer\"{" +
            "jump\uFEFF0\n" +
            "}";
        //expect(IllegalArgumentException.class, () -> gameInfo.simulate(10, -12, map, brain, brainx));
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(10, -12, map, brain, brain1));
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(10, -12, map, brain, brain2));
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(10, -12, map, brain, brain3));
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(10, -12, map, brain, brain4));
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(10, -12, map, brain, brain5));
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(10, -12, map, brain, brain6));
    }
}
