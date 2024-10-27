package saarland.cispa.sopra.systemtests.giuliano.sense;

import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;
import saarland.cispa.sopra.systemtests.WorldInfo;

public abstract class SenseNotHere extends SenseTest {
    private int sensorX;
    private int sensorY;
    private int sensedX;
    private int sensedY;

    @Override
    protected void test(GameInfo gameInfo) {
        String brains;
        WorldInfo w;
        MapBuilder builder = getBuilder();
        String[] keywords = getSensableKeywords();
        char[] objects = getSensableObjects();
        for(int i = 0; i < keywords.length; i++) {
            for(int j = 0; j < keywords.length; j++) {
                builder.set(getSensedX(),getSensedY(),objects[j]);
                brains = generateBrain("sense " + getDirection() + " " + keywords[i] + " else 0", "jump 1");
                w = gameInfo.simulate(1,0,builder.export(),brains,brains);
                checkSense(w.getFieldAt(getSensorX(),getSensorY()), objects[i] == objects[j], String.format("Keyword: %s objects[i]: %c objects[j]: %c", keywords[i], objects[i], objects[j]));
            }
        }
    }

    public int getSensorX() {
        return sensorX;
    }

    public void setSensorX(int sensorX) {
        this.sensorX = sensorX;
    }

    public int getSensorY() {
        return sensorY;
    }

    public void setSensorY(int sensorY) {
        this.sensorY = sensorY;
    }

    public int getSensedX() {
        return sensedX;
    }

    public void setSensedX(int sensedX) {
        this.sensedX = sensedX;
    }

    public int getSensedY() {
        return sensedY;
    }

    public void setSensedY(int sensedY) {
        this.sensedY = sensedY;
    }

    public abstract MapBuilder getBuilder();
    public abstract String getDirection();




}
