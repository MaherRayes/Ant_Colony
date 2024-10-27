package saarland.cispa.sopra.saarmeisen.instruction;

import saarland.cispa.sopra.saarmeisen.Ant;
import saarland.cispa.sopra.saarmeisen.World;

/**
 * An unconditional jump instruction is interpreted as
 * a {@link FailableInstruction} which fails every time
 * so it wll jump to its failIndex
 */
public class JumpInstruction extends FailableInstruction {

	public JumpInstruction(int index) {
		super(index);
	}

	@Override
	protected boolean execute(World world, Ant executor) {
		return false;
	}

    /**
     * Yes, serialize is intended here. We do not care about serializeFailable
     * @return
     */
    @Override
    public String serialize() {
        return "jump " + getFailIndex();
    }

    @Override
    protected String serializeFailable() {
        throw new IllegalArgumentException("This should never be called");
    }
}
