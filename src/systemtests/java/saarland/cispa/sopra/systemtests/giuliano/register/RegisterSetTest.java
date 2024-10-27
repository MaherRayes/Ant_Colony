package saarland.cispa.sopra.systemtests.giuliano.register;

import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.Arrays;
import java.util.Optional;

public class RegisterSetTest extends RegisterTest {
    @Override
    public String getBrainA() {
        return generateBrain("move else 5", "set 0", "set 1", "set 2", "unset 0", "jump 5");
    }

    @Override
    public String getBrainB() {
        return generateBrain("jump 1", "jump 2", "jump 3", "jump 4", "set 0", "set 1", "set 2", "set 3", "set 4", "set 5", "unset 0", "unset 1", "unset 2", "jump 13");
    }

    @Override
    protected void test(GameInfo gameInfo) {
        WorldInfo w;
        boolean[] aValues = {true, true, true, false, false, false};
        boolean[] bValues = {false, false, false, true, true, true};
        boolean[] initial = {false, false, false, false, false, false};
        setRounds(4);
        w = getWorld(gameInfo);
        Optional<AntInfo> o = w.getFieldAt(1, 1).getAnt();
        if(o.isPresent()) {
            if(!Arrays.equals(o.get().getRegister(), aValues)) {
                fail("Registers has not been set correctly.");
            }
        }
        o = w.getFieldAt(0, 1).getAnt();
        if(o.isPresent()) {
            if(!Arrays.equals(o.get().getRegister(), initial)) {
                fail("Registers of own team were overridden.");
            }
        }
        o = w.getFieldAt(2, 2).getAnt();
        if(o.isPresent()) {
            if(!Arrays.equals(o.get().getRegister(), initial)) {
                fail("Registers of enemy team were overridden.");
            }
        }
        setRounds(13);
        w = getWorld(gameInfo);
        o = w.getFieldAt(1, 1).getAnt();
        if(o.isPresent()) {
            if(!Arrays.equals(o.get().getRegister(), aValues)) {
                fail("Registers of enemy team were overridden.");
            }
        }
        o = w.getFieldAt(2, 2).getAnt();
        if(o.isPresent()) {
            if(!Arrays.equals(o.get().getRegister(), bValues)) {
                fail("Registers has not been set correctly.");
            }
        }
    }
}
