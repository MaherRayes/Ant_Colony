package saarland.cispa.sopra.saarmeisen.instruction;

import saarland.cispa.sopra.saarmeisen.Ant;
import saarland.cispa.sopra.saarmeisen.World;

public abstract class NonFailableInstruction extends Instruction {
	protected abstract void execute(World world, Ant executor);

	@Override
	public void run(World world, Ant executor) {
	    if(executor.getRestTime() == 0) {
            execute(world, executor);
            executor.incPc();
        } else {
	        executor.setRestTime(executor.getRestTime()-1);
        }

	}
}
