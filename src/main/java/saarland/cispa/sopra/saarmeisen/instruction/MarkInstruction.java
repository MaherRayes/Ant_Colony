package saarland.cispa.sopra.saarmeisen.instruction;

import saarland.cispa.sopra.saarmeisen.Ant;
import saarland.cispa.sopra.saarmeisen.World;

public class MarkInstruction extends NonFailableInstruction {

	private final int index;
	private final boolean value;

	public MarkInstruction(int index, boolean value) {
		this.index = index;
		this.value = value;
	}

	@Override
	protected void execute(World world, Ant executor) {
        var swarmChar = executor.getSwarm();
        executor.getField().getMarkers().get(swarmChar)[index] = value;
	}

    @Override
    public String serialize() {
        if(value){
            return "mark " + index;
        }else{
            return "unmark " + index;
        }
    }

    public int getIndex() {
        return index;
    }
}
