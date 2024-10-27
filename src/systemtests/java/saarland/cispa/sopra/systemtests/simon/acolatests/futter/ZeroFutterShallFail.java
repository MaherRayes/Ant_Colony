package saarland.cispa.sopra.systemtests.simon.acolatests.futter;

import saarland.cispa.sopra.systemtests.GameInfo;

public class ZeroFutterShallFail extends FutterBase {
    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);

        getMapper().setField(1, 0, '0');

        String map = getMapper().toString();
        String brain = createNewBrain(  "move else 3", "pickup else 3", "jump 2", "jump 3");

        expect(IllegalArgumentException.class, () -> simulate(50, 42, map, brain, trivialBrain()));


    }
}
