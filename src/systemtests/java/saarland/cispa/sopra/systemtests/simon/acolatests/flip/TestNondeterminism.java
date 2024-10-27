package saarland.cispa.sopra.systemtests.simon.acolatests.flip;

import saarland.cispa.sopra.systemtests.simon.BaseTest;
import saarland.cispa.sopra.systemtests.GameInfo;

public class TestNondeterminism extends BaseTest {

    private boolean seen1;
    private boolean seen2;

    @Override
    protected void test(GameInfo gameInfo) {
        setGameInfo(gameInfo);


        for(int i = 0; i <1000; i++){
            verifyWithSeed(i);
        }

    /*    if(!seen1 || !seen2){
            fail("Komischer Zufall");
        }
*/
    }


    private void verifyWithSeed(int seed){
        String brain = createNewBrain( "flip 2 else 2", "jump 1", "jump 2");
        String map = getMapper().toString();

        int pc = gameInfo.simulate(5, seed, map, brain, brain).getAnt(0).getPc();

        seen1 |= pc == 1;
        seen2 |= pc == 2;

        if(pc != gameInfo.simulate(5, seed, map, brain, brain).getAnt(0).getPc()){
            fail("Nondet");
        }
    }

}
