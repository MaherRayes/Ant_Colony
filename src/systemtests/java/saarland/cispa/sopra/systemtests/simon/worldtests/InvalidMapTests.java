package saarland.cispa.sopra.systemtests.simon.worldtests;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class InvalidMapTests extends BaseTest {

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        expect(IllegalArgumentException.class, () -> simulate(0, 42, "2\n..\n..", trivialBrain(), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(0, 42, "2\n4\n..\n..", trivialBrain(), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(0, 42, "", trivialBrain(), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(0, 42, "ASD\nASD\n..\n..", trivialBrain(), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(0, 42, "0\n0\n\n", trivialBrain(), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(0, 42, "100\n100\n", trivialBrain(), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(0, 42, "1\n1\n.\n", trivialBrain(), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(0, 42, "2\n2\n/.\n/.\n", trivialBrain(), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(0, 42, "2\n2\n=.\n..\n", trivialBrain(), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(0, 42, "2\n2\n0.\n..\n", trivialBrain(), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(0, 42, "2\n2\n^.\n..\n", trivialBrain(), trivialBrain()));
        expect(IllegalArgumentException.class, () -> simulate(0, 42, "2\n2\n,.\n..\n", trivialBrain(), trivialBrain()));

    }

}
