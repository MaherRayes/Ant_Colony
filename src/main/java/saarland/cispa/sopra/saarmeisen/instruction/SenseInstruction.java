package saarland.cispa.sopra.saarmeisen.instruction;

import saarland.cispa.sopra.saarmeisen.Ant;
import saarland.cispa.sopra.saarmeisen.Direction;
import saarland.cispa.sopra.saarmeisen.World;
import saarland.cispa.sopra.saarmeisen.field.AntLionField;
import saarland.cispa.sopra.saarmeisen.field.BaseField;
import saarland.cispa.sopra.saarmeisen.field.Field;
import saarland.cispa.sopra.saarmeisen.field.RockField;
import saarland.cispa.sopra.systemtests.AntInfo;

import java.util.Map;

public class SenseInstruction extends FailableInstruction {

    final private SensableObject sensableObject;
    final private RelativeDirection relativeDirection;
    private int markerIndex;

    public SenseInstruction(int failIndex, SensableObject sensableObject, RelativeDirection relativeDirection) {
        super(failIndex);
        this.sensableObject = sensableObject;
        this.relativeDirection = relativeDirection;
    }

    public SenseInstruction(int failIndex, SensableObject sensableObject, RelativeDirection relativeDirection, int markerIndex) {
        super(failIndex);
        if(!(markerIndex >= 0 && markerIndex < 7)) {
            throw new IllegalArgumentException();
        }
        this.sensableObject = sensableObject;
        this.relativeDirection = relativeDirection;
        this.markerIndex = markerIndex;
    }

    @Override
    protected boolean execute(World world, Ant executor) {

        boolean checkField = false;

        //get the targetField

        Field targetField = getTargetField(relativeDirection, world, executor);

        //Check the field we got

        switch(sensableObject) {

            case friend:
                if(targetField.getAntObject() != null) {
                    checkField = targetField.getAntObject().getSwarm() == executor.getSwarm();
                }
                break;

            case foe:
                if(targetField.getAntObject() != null) {
                    checkField = targetField.getAntObject().getSwarm() != executor.getSwarm();
                }
                break;

            case home:
                checkField = targetField.getType() == executor.getSwarm();
                break;

            case foehome:
                checkField = targetField instanceof BaseField && targetField.getType() != executor.getSwarm();
                break;

            case food:
                checkField = targetField.getFood() != 0;
                break;

            case rock:
                checkField = targetField instanceof RockField;
                break;

            case marker:
                checkField = targetField.getMarkers().get(executor.getSwarm())[markerIndex];
                break;

            default:
                checkField = execute2(world, executor, targetField);
                break;
        }
        return checkField;
    }

    //private methodes for execute(to make it smaller)
    private boolean execute2(World world, Ant executor, Field targetField) {

        boolean checkField = false;

        switch(sensableObject) {

            case friendfood: {
                Ant targetAnt = targetField.getAntObject();
                if(targetAnt != null) {
                    checkField = targetAnt.getSwarm() == executor.getSwarm() && targetAnt.hasFood();
                }
            }
            break;

            case foemarker:
                checkField = foemarker(targetField, executor);
                break;

            case foefood: {
                Ant targetAnt = targetField.getAntObject();
                if(targetAnt != null) {
                    checkField = targetAnt.getSwarm() != executor.getSwarm() && targetAnt.hasFood();
                }
            }
            break;

            case antlion:
                checkField = antlion(world, targetField);
                break;

            default:
                checkField = false;
                break;
        }

        return checkField;

    }

    private Field getTargetField(RelativeDirection relativeDirection, World world, Ant executor) {

        Field targetField = null;
        Direction dir = executor.getDirectionObject();
        Field field = executor.getField();

        switch(relativeDirection) {

            case here:
                targetField = field;
                break;

            case ahead:
                targetField = world.getTargetField(dir, field);
                break;

            case left: {
                Direction absoluteDirection = dir.getLeft();
                targetField = world.getTargetField(absoluteDirection, field);
            }
            break;

            case right: {
                Direction absoluteDirection = dir.getRight();
                targetField = world.getTargetField(absoluteDirection, field);
            }
            break;
        }

        return targetField;

    }

    private boolean foemarker(Field targetField, AntInfo executor) {
        // TODO
        Map<Character, boolean[]> marker = targetField.getMarkers();

        return marker.keySet().stream().filter(charr -> charr != executor.getSwarm()).map(marker::get).anyMatch(boolArr -> {
            boolean toReturn = false;
            for(boolean check : boolArr) {
                toReturn |= check;
            }
            return toReturn;
        });
    }

    private boolean antlion(World world, Field targetField) {

        if(targetField instanceof AntLionField) {
            return true;
        }

        for(Field field : world.getNeighborFields(targetField)) {
            if(field instanceof AntLionField) {
                return true;
            }
        }
        return false;
    }
    //

    public SensableObject getSensableObject() {
        return sensableObject;
    }

    public int getMarkerIndex() {
        return markerIndex;
    }

    @Override
    protected String serializeFailable() {
        return "sense " + relativeDirection + " " + sensableObject + (sensableObject == SensableObject.marker ? " " + markerIndex : "");
    }
}
