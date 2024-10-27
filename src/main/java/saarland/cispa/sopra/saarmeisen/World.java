package saarland.cispa.sopra.saarmeisen;

import saarland.cispa.sopra.saarmeisen.field.Field;
import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

import javax.json.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class World implements WorldInfo {
    private final int width;
    private final int height;
    private final Map<Character, Swarm> swarms;
    private final List<Ant> ants;
    private final Field[][] fields;
    private final static int minFieldSize = 2;
    private final static int maxFieldSize = 128;

    public World(int width, int height, List<Ant> ants, Field[][] fields, Map<Character, Swarm> swarms) {
        this.width = width;
        this.height = height;
        this.ants = ants;
        this.fields = fields.clone();
        this.swarms = swarms;
        //check if world is correct
        //Testet, ob Karte nicht zu groß oder zu klein ist
        this.testWidthAndHeight(width, height);
        //Testet, ob keine Lücke in den Schwärmen vorhanden ist
        int count = 0;
        for(char c = 'A'; true; c++) {
            if(swarms.containsKey(c)) {
                count++;
            } else {
                if(count < swarms.size()) {
                    throw new IllegalArgumentException();
                }
                if(count > swarms.size()) {
                    throw new IllegalArgumentException("Komischer Fehler");
                }
                break;
            }
        }
        //Testet,ob Schwarm zusammenhängend auf der Karte ist
        for(char c = 'A'; c < 'A' + swarms.size(); c++) {
            isBaseConnected(c);
        }

    }

    private void testWidthAndHeight(int width, int height) {
        if(width < minFieldSize || height < minFieldSize) {
            throw new IllegalArgumentException();
        }
        if(width > maxFieldSize || height > maxFieldSize) {
            throw new IllegalArgumentException();
        }
        //Testet, ob Höhe und Breite gerade ist
        if((width % 2) != 0 || (height % 2) != 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Ant getAnt(int index) {
        if(ants.size() > index && index >= 0) {
            if(!ants.get(index).isAlive()) {
                throw new NoSuchElementException("ant was dead");
            }
            return ants.get(index);
        } else {
            throw new NoSuchElementException();
        }
    }

    public List<Ant> getHostileNeighborAnts(Ant ant) {
        if(ant == null) {
            throw new IllegalArgumentException("Ameise war null");
        }
        char swarm = ant.getSwarm();    //Schwarm der betrachteten Ameise
        Field field = ant.getField();
        List<Field> fieldList = this.getNeighborFields(field);  //Nachbarfelder der Ameise
        List<Ant> antList = new ArrayList<>();
        for(Field currentField : fieldList) {
            Ant fieldAnt = currentField.getAntObject();
            if(fieldAnt == null) {
                continue;
            }
            if(fieldAnt.getSwarm() != swarm) {
                antList.add(fieldAnt);
            }
        }
        return antList;
    }

    public List<Field> getNeighborFields(Field field) {
        if(field == null) {
            throw new IllegalArgumentException("Feld war null");
        }
        List<Field> list = new ArrayList<>(6);
        Direction[] directionArray = Direction.values();
        Field targetField;

        for(Direction dir : directionArray) {
            targetField = this.getTargetField(dir, field);
            list.add(targetField);
        }
        return list;
    }

    @Override
    public Field getFieldAt(int xCoord, int yCoord) {
        testCoordinates(xCoord, yCoord);
        return fields[xCoord][yCoord];
    }

    public Field getTargetField(Direction direction, Field field) {
        return getTargetField(direction, field.getX(), field.getY());
    }

    public Field getTargetField(Direction direction, int xCoord, int yCoord) {
        testCoordinates(xCoord, yCoord);

        int newX;
        int newY;
        switch(direction) {
            case northwest:
                if(yCoord % 2 == 0) {
                    newX = xCoord - 1;
                } else {
                    newX = xCoord;
                }
                newY = yCoord - 1;
                break;

            case northeast:
                if(yCoord % 2 == 0) {
                    newX = xCoord;
                } else {
                    newX = xCoord + 1;
                }
                newY = yCoord - 1;
                break;

            case east:
                newX = xCoord + 1;
                newY = yCoord;
                break;

            case southeast:
                if(yCoord % 2 == 0) {
                    newX = xCoord;
                } else {
                    newX = xCoord + 1;
                }
                newY = yCoord + 1;
                break;

            case southwest:
                if(yCoord % 2 == 0) {
                    newX = xCoord - 1;
                } else {
                    newX = xCoord;
                }
                newY = yCoord + 1;
                break;

            case west:
                newX = xCoord - 1;
                newY = yCoord;
                break;

            default:
                throw new IllegalArgumentException("Fall bei Direction vergessen");
        }

        newX = Math.floorMod(newX, this.getWidth());
        newY = Math.floorMod(newY, this.getHeight());

        return this.getFieldAt(newX, newY);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public Collection<Swarm> getSwarms() {
        return swarms.values();
    }

    @Override
    public int getScore(char swarm) {
        if(swarm < 'A' || swarm >= 'A' + swarms.size()) {
            throw new IllegalArgumentException();
        }
        return swarms.get(swarm).getScore();
    }

    @Override
    @Deprecated
    public List<AntInfo> getAnts() {
        return ants.stream().filter(Ant::isAlive).collect(Collectors.toList());
    }

    public List<Ant> getAntObjects() {
        return new ArrayList<>(ants);
    }

    public Field[][] getFields() {
        return fields.clone();
    }

    public JsonObject serializeInit(JsonBuilderFactory factory) {
        JsonObjectBuilder initBuilder = factory.createObjectBuilder();
        JsonArrayBuilder brainBuilder = factory.createArrayBuilder();
        JsonArrayBuilder fieldBuilder = factory.createArrayBuilder();

        initBuilder.add("width", width);
        initBuilder.add("height", height);

        swarms.values().stream().map(Swarm::getProgram).map(program -> program.serialize(factory)).forEach(brainBuilder::add);
        initBuilder.add("brains", brainBuilder);

        Arrays.stream(fields).flatMap(Arrays::stream).map(Field::serialize).forEach(fieldBuilder::add);
        initBuilder.add("fields", fieldBuilder);

        return initBuilder.build();
    }

    public JsonArray serializeChanges(JsonBuilderFactory factory) {
        // TODO marker if all false
        JsonArrayBuilder fieldBuilder = factory.createArrayBuilder();

        Arrays.stream(fields).flatMap(Arrays::stream).filter(Field::writeToLog).map(Field::serialize).forEach(fieldBuilder::add);
        Arrays.stream(fields).flatMap(Arrays::stream).forEach(Field::resetChanged);

        return fieldBuilder.build();
    }

    public void killAnt(Ant ant) {
        if(ant == null) {
            throw new IllegalArgumentException("Nicht vorhandene Ameise kann nicht getötet werden (war null)");
        }
        ant.getField().setAnt(null);
        if(ant.hasFood()) {
            ant.getField().addFood(1);
        }
        ant.getField().addFood(3);
        ant.setAlive(false);
        ant.getSwarmObject().removeAnt();
    }

    public void eatAnt(Ant ant) {
        ant.getField().setAnt(null);
        ant.getField().addFood(1);
        ant.setAlive(false);
        ant.getSwarmObject().removeAnt();
    }

    private void isBaseConnected(char swarmChar) {
        if(!swarms.containsKey(swarmChar)) {
            throw new IllegalArgumentException();
        }
        //Sucher erste Basis
        Field base1 = null;
        int countBase = 0;
        for(Field[] fArr : fields) {
            for(Field currentField : fArr) {
                if(currentField.getType() == swarmChar) {
                    base1 = currentField;
                    countBase++;//Zählt, wie oft es die Basis gibt
                    continue;
                }
            }
        }
        if(base1 == null) {
            throw new IllegalArgumentException();
        }
        Set<Field> baseSet = new HashSet<>(); //Enthält am Ende alle Basen
        baseSet.add(base1);

        //Füge alle an dieser Menge hängenden Basen in die Menge hinzu
        Queue<Field> fieldQueue = new LinkedBlockingQueue<>();
        fieldQueue.add(base1);
        while(!fieldQueue.isEmpty()) {
            Field base = fieldQueue.poll();
            List<Field> neighbors = this.getNeighborFields(base);
            for(Field currentField : neighbors) {
                if(currentField.getType() == swarmChar) {
                    //Wenn Feld Basis von c ist, füge es hinzu
                    if(baseSet.add(currentField)) {
                        fieldQueue.add(currentField);
                    }
                }
            }
        }

        if(countBase != baseSet.size()) {
            throw new IllegalArgumentException();
        }

    }

    private void testCoordinates(int xCoord, int yCoord) {
        if(xCoord < 0 || yCoord < 0 || xCoord >= getWidth() || yCoord >= getHeight()) {
            throw new NoSuchElementException();
        }
    }

    public void addAnt(Ant ant2) {
        ants.add(ant2);
    }

    public Map<Character, Swarm> getSwarmMap() {
        return this.swarms;
    }
}
