package saarland.cispa.sopra.saarmeisen.instruction;

import saarland.cispa.sopra.saarmeisen.Ant;
import saarland.cispa.sopra.saarmeisen.World;

public abstract class FailableInstruction extends Instruction {

	private final int failIndex;

	public FailableInstruction(int failIndex) {
		this.failIndex = failIndex;
	}

	protected abstract boolean execute(World world, Ant executor);

	@Override
	public void run(World world, Ant executor) {
	    if(executor.getRestTime() == 0) {
            if (execute(world, executor)) {
                executor.incPc();
            } else {
                executor.setPc(failIndex);
            }
        } else {
            executor.setRestTime(executor.getRestTime()-1);
        }
	}

    @Override
    public String serialize() {
        return serializeFailable() + " else " + failIndex;
    }
    protected abstract String serializeFailable();

    public int getFailIndex() {
        return failIndex;
    }
}
