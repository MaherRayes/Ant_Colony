package saarland.cispa.sopra.saarmeisen.instruction;

import saarland.cispa.sopra.saarmeisen.Ant;
import saarland.cispa.sopra.saarmeisen.Direction;
import saarland.cispa.sopra.saarmeisen.World;

public class DirectionInstruction extends FailableInstruction {

	private final Direction direction;

	public DirectionInstruction(int failIndex, Direction direction) {
		super(failIndex);
		this.direction = direction;
	}

	@Override
	protected boolean execute(World world, Ant executor) {

	    return executor.getDirectionObject() == direction;

	}

    @Override
    protected String serializeFailable() {
        return "direction " + direction.toString();
    }
}
