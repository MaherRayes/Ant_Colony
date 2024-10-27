package saarland.cispa.sopra.saarmeisen.instruction;

import saarland.cispa.sopra.saarmeisen.*;
import saarland.cispa.sopra.saarmeisen.field.Field;


public class BreedInstruction extends FailableInstruction {

    public BreedInstruction(int failIndex) {
        super(failIndex);
    }

    @Override
    protected boolean execute(World world, Ant executor) {



        //check if the ant has food to breed
        if (!executor.hasFood()) {
            return false;
        }

        Field field0 = executor.getField();
        Direction dir = executor.getDirectionObject();
        Field field1 = world.getTargetField(dir, field0);
        Ant ant1 = field1.getAntObject();

        if (ant1 == null || !ant1.hasFood()) {
            return false;
        }

        if (executor.getSwarm() != ant1.getSwarm()) {
            return false;
        }



        Field emptyField = findEmptyField(field0, field1, world);
        if (emptyField == null) {
            return false;
        }
        Swarm swarm0 = executor.getSwarmObject();
        //initialising the new breeded ant on the field
        Brain brain2 = new Brain();
        Ant ant2 = new Ant(emptyField, world.getAntObjects().size(), false, swarm0, 0, brain2, Direction.northwest);
        emptyField.setAnt(ant2);
        world.addAnt(ant2);
        swarm0.setAnts(swarm0.getAnts() + 1);

        //After breeding the ants lose food
        executor.setHasFood(false);
        ant1.setHasFood(false);

        setAffectedAnt(ant2);
        return true;
    }


    private Field findEmptyField(Field field0, Field field1, World world) {

        Field field = null;

        for (Field fieldi : world.getNeighborFields(field0)) {
            if (fieldi.isTraversable()) {
                field = fieldi;
                break;
            }
        }

        if (field == null) {
            for (Field fieldi : world.getNeighborFields(field1)) {
                if (fieldi.isTraversable()) {
                    field = fieldi;
                    break;
                }
            }
        }

        return field;

    }



    @Override
    public boolean checkSideEffectKill() {
        return true;
    }


    @Override
    protected String serializeFailable() {
        return "breed";
    }

}
