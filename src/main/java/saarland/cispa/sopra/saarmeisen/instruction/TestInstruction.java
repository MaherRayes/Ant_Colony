package saarland.cispa.sopra.saarmeisen.instruction;

import saarland.cispa.sopra.saarmeisen.Ant;
import saarland.cispa.sopra.saarmeisen.World;

public class TestInstruction extends FailableInstruction {

    private final int registerIndex;

    public TestInstruction(int failIndex, int registerIndex) {
        super(failIndex);
        if(!(registerIndex >= 0 && registerIndex < 6)) {
            throw new IllegalArgumentException();
        }
        this.registerIndex = registerIndex;
    }

    @Override
    protected boolean execute(World world, Ant executor) {
        return executor.getRegister()[registerIndex];
    }

    @Override
    protected String serializeFailable() {
        return "test " + registerIndex;
    }

    public int getRegisterIndex() {
        return registerIndex;
    }
}
