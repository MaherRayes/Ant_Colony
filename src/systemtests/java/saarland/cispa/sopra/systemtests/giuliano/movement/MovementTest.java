package saarland.cispa.sopra.systemtests.giuliano.movement;

import saarland.cispa.sopra.systemtests.*;
import saarland.cispa.sopra.systemtests.giuliano.BaseTest;
import saarland.cispa.sopra.systemtests.giuliano.Direction;
import saarland.cispa.sopra.systemtests.giuliano.WorldGenerator;

import java.util.ArrayList;

public abstract class MovementTest extends BaseTest {


    public FieldInfo calculateTarget(WorldInfo world, AntInfo ant) {
        FieldInfo field = ant.getField();
        Direction d = Direction.toDirection(ant.getDirection());
        return calculateTarget(world, field, d);
    }

    public FieldInfo calculateTarget(WorldInfo world, FieldInfo field, Direction d) {
        switch(d) {
            case northwest:
                return goNorthWest(world, field);
            case northeast:
                return goNorthEast(world, field);
            case east:
                return goEast(world, field);
            case southeast:
                return goSouthEast(world, field);
            case southwest:
                return goSouthWest(world, field);
            case west:
                return goWest(world, field);
        }
        return world.getFieldAt(-1, -1);
    }

    public FieldInfo goNorthWest(WorldInfo world, FieldInfo field) {
        int x = field.getX();
        int y = field.getY();
        checkCoordinates(x, y);
        if(y % 2 == 0) {
            x--;
            if(x < 0) {
                x = world.getWidth() - 1;
            }
        }
        y--;
        if(y < 0) {
            y = world.getHeight() - 1;
        }
        return world.getFieldAt(x, y);
    }

    public FieldInfo goNorthEast(WorldInfo world, FieldInfo field) {
        int x = field.getX();
        int y = field.getY();
        checkCoordinates(x, y);
        if(y % 2 != 0) {
            x++;
            if(x >= world.getWidth()) {
                x = 0;
            }
        }
        y--;
        if(y < 0) {
            y = world.getHeight() - 1;
        }
        return world.getFieldAt(x, y);
    }

    public FieldInfo goSouthWest(WorldInfo world, FieldInfo field) {
        int x = field.getX();
        int y = field.getY();
        checkCoordinates(x, y);
        if(y % 2 == 0) {
            x--;
            if(x < 0) {
                x = world.getWidth() - 1;
            }
        }
        y++;
        if(y >= world.getHeight()) {
            y = 0;
        }
        return world.getFieldAt(x, y);
    }

    public FieldInfo goSouthEast(WorldInfo world, FieldInfo field) {
        int x = field.getX();
        int y = field.getY();
        checkCoordinates(x, y);
        if(y % 2 != 0) {
            x++;
            if(x >= world.getWidth()) {
                x = 0;
            }
        }
        y++;
        if(y >= world.getHeight()) {
            y = 0;
        }
        return world.getFieldAt(x, y);
    }

    public FieldInfo goWest(WorldInfo world, FieldInfo field) {
        int x = field.getX();
        int y = field.getY();
        checkCoordinates(x, y);
        x--;
        if(x < 0) {
            x = world.getWidth() - 1;
        }
        return world.getFieldAt(x, y);
    }

    public FieldInfo goEast(WorldInfo world, FieldInfo field) {
        int x = field.getX();
        int y = field.getY();
        checkCoordinates(x, y);
        x++;
        if(x >= world.getWidth()) {
            x = 0;
        }
        return world.getFieldAt(x, y);
    }

    public WorldGenerator getNTurnsOneMoveGenerator(GameInfo gameInfo, String map) {
        return (turns) -> {
            ArrayList<String> code = new ArrayList<>();
            for(int i = 0; i < turns; i++) {
                code.add("turn right");
            }
            code.add("move else 0");
            code.add("jump 0");
            return gameInfo.simulate(turns+1,0, map, generateBrain(code), getEmptyBrain());
        };
    }
}
