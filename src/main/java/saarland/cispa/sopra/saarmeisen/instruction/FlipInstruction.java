package saarland.cispa.sopra.saarmeisen.instruction;

import saarland.cispa.sopra.saarmeisen.Ant;
import saarland.cispa.sopra.saarmeisen.World;

import java.util.Random;

public class FlipInstruction extends FailableInstruction {

	private final Random random;
	private final int max;

	public FlipInstruction(int failIndex, Random random, int max) {
		super(failIndex);
		this.random = random;
		this.max = max;
	}

	@Override
	protected boolean execute(World world, Ant executor) {
	    return 0 == random.nextInt(Math.max(1,max));
	}

    public int getMax() {
        return max;
    }

    @Override
    protected String serializeFailable() {
        return "flip " + getMax();
    }
}
