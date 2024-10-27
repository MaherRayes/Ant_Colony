package saarland.cispa.sopra.saarmeisen.instruction;

import saarland.cispa.sopra.saarmeisen.Ant;
import saarland.cispa.sopra.saarmeisen.World;

public class PickupInstruction extends FailableInstruction {

	public PickupInstruction(int failIndex) {
		super(failIndex);
	}

	@Override
	protected boolean execute(World world, Ant executor) {

	    if(executor.hasFood() || executor.getField().getFood() == 0){
	        return false;
        }else{
	        executor.getField().pickupFood();
	        executor.setHasFood(true);
	        return true;
        }

	}

    @Override
    protected String serializeFailable() {
        return "pickup";
    }
}
