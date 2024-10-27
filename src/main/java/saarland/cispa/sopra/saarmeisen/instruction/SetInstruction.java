package saarland.cispa.sopra.saarmeisen.instruction;

import saarland.cispa.sopra.saarmeisen.Ant;
import saarland.cispa.sopra.saarmeisen.World;

public class SetInstruction extends NonFailableInstruction {

    private final int register;
    private final boolean value;

    public SetInstruction(int register, boolean value) {
        if(!(register >= 0 && register < 7)) {
            throw new IllegalArgumentException();
        }
        this.register = register;
        this.value = value;
    }

    @Override
    protected void execute(World world, Ant executor) {
        executor.getBrain().setRegister(register, value);
    }

    public int getRegister() {
        return register;
    }

    @Override
    public String serialize() {
        if(value) {
            return "set " + getRegister();
        } else {
            return "unset " + getRegister();
        }
    }

}
