package saarland.cispa.sopra.saarmeisen.field;

import saarland.cispa.sopra.saarmeisen.Ant;
import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.FieldInfo;

import javax.json.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class Field implements FieldInfo {

    public static final int MARKER_AMOUNT = 7;

    private final int xCoord;
    private final int yCoord;
    private Ant ant;
    private int food;
    private final Map<Character, boolean[]> markers;
    private boolean changed;

    public Field(int xCoord, int yCoord, Ant ant, int food, int teams) {
        if(xCoord < 0 || yCoord < 0) {
            throw new IllegalArgumentException();
        }
        if(!(teams > 0 && food >= 0)) {
            throw new IllegalArgumentException();
        }
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.ant = ant;
        this.food = food;
        this.markers = new HashMap<>(teams);

        for(int i = 0; i < teams; i++) {
            char aChar = 'A';
            aChar += i;
            markers.put(aChar, new boolean[7]);
        }
    }

    public boolean wasChanged() {
        return changed;
    }

    public boolean writeToLog() {
        return ant != null || wasChanged();
    }

    public void resetChanged() {
        this.changed = false;
    }

    public void addFood(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException();
        }
        setChanged();
        this.food += amount;
    }

    public boolean isTraversable() {
        return ant == null;
    }

    public boolean pickupFood() {
        if(food > 0) {
            food--;
            setChanged();
            return true;
        } else {
            return false;
        }
    }

    public void setAnt(Ant ant) {
        setChanged();
        this.ant = ant;
    }

    public void setChanged() {
        this.changed = true;
    }

    @Override
    public int getX() {
        return xCoord;
    }

    @Override
    public int getY() {
        return yCoord;
    }

    @Override
    public Optional<AntInfo> getAnt() {
        return Optional.ofNullable(ant);
    }

    public Ant getAntObject() {
        return ant;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public abstract char getType();

    @Override
    public Map<Character, boolean[]> getMarkers() {
        return markers;
    }

    public JsonObject serialize() {
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonObjectBuilder builder = factory.createObjectBuilder();
        JsonArrayBuilder markerBuilder = factory.createArrayBuilder();

        builder.add("x", getX()).add("y", getY()).add("type", new String(new char[] {getType()}));

        if(ant != null) {
            builder.add("ant", ant.serialize());
        }
        if(this instanceof PlaneField) {
            builder.add("food", getFood());
        }

        markers.keySet().stream().filter(cchar -> {
            boolean wasSet = false;
            for(boolean localMarker : markers.get(cchar)) {
                wasSet |= localMarker;
            }
            return wasSet;
        }).
            map(cchar -> {
                JsonObjectBuilder temptemp = factory.createObjectBuilder();
                temptemp.add("swarm_id", new String(new char[] {cchar}));
                JsonArrayBuilder markerArray = factory.createArrayBuilder();
                for(boolean localMarker : markers.get(cchar)) {
                    markerArray.add(localMarker);
                }

                temptemp.add("values", markerArray);
                return temptemp;
            }).forEach(markerBuilder::add);
        builder.add("markers", markerBuilder);

        return builder.build();
    }
}
