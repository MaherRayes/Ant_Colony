package saarland.cispa.sopra.saarmeisen.instruction;

import saarland.cispa.sopra.saarmeisen.Ant;
import saarland.cispa.sopra.saarmeisen.Direction;
import saarland.cispa.sopra.saarmeisen.World;
import saarland.cispa.sopra.saarmeisen.field.Field;

public class MoveInstruction extends FailableInstruction {

	public static final int REST_TIME_AFTER_MOVE = 13;
	public static final int UMZINGEL_NEED_MIN_ANTS = 5;

	//TODO manual restTime
	public MoveInstruction(int failIndex) {
		super(failIndex);
	}

    @Override
    protected boolean execute(World world, Ant executor) {

	    setAffectedAnt(executor);

        Direction dir = executor.getDirectionObject();
        Field field0 = executor.getField();
        Field field1 = world.getTargetField(dir,field0);

        if(field1.isTraversable()){
            field1.setAnt(executor);
            field0.setAnt(null);
            executor.setField(field1);
            executor.setRestTime(13);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean checkSideEffectKill() {
        return true;
    }

    @Override
    protected String serializeFailable() {
        return "move";
    }
}
