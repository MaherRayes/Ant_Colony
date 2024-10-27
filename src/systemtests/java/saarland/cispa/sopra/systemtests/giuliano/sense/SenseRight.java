package saarland.cispa.sopra.systemtests.giuliano.sense;

import saarland.cispa.sopra.systemtests.giuliano.MapBuilder;

public class SenseRight extends SenseNotHere {
    @Override
    public MapBuilder getBuilder() {
        setSensorX(0);
        setSensorY(1);
        setSensedX(1);
        setSensedY(0);
        MapBuilder builder = new MapBuilder(2,2);
        builder.set(0,1,'A').set(0,0,'B');
        return builder;
    }

    @Override
    public String getDirection() {
        return "right";
    }
}
