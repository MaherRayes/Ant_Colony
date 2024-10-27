package saarland.cispa.sopra.saarmeisen.instruction;

import saarland.cispa.sopra.saarmeisen.Ant;
import saarland.cispa.sopra.saarmeisen.World;

public class TurnInstruction extends NonFailableInstruction {

	private final TurnDirection turnDirection;

	public TurnInstruction(TurnDirection turnDirection) {
		this.turnDirection = turnDirection;
	}

	@Override
	protected void execute(World world, Ant executor) {
        if(turnDirection == TurnDirection.left) {
            executor.setDirection(executor.getDirectionObject().getLeft());
        }else {
            executor.setDirection(executor.getDirectionObject().getRight());
        }

	}

    @Override
    public String serialize() {
        return "turn " + turnDirection;
    }
}
