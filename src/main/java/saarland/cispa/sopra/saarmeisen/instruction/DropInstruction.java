package saarland.cispa.sopra.saarmeisen.instruction;

import saarland.cispa.sopra.saarmeisen.Ant;
import saarland.cispa.sopra.saarmeisen.World;

public class DropInstruction extends FailableInstruction {

	public DropInstruction(int failIndex) {
		super(failIndex);
	}

	@Override
	protected boolean execute(World world, Ant executor) {

        if(executor.hasFood()){
            executor.getField().addFood(1);
            executor.setHasFood(false);
            return true;
        }else{
            return false;
        }

	}

    @Override
    protected String serializeFailable() {
        return "drop";
    }
}
