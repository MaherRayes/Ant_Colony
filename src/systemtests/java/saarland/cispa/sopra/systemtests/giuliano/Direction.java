package saarland.cispa.sopra.systemtests.giuliano;


import java.util.EnumSet;
import java.util.Set;

public enum Direction {
    northeast,
    northwest,
    southeast,
    southwest,
    east,
    west;

    public static Set<Direction> getSet() {
        return EnumSet.allOf(Direction.class);
    }

    public static int toInt(Direction direction) {
        switch(direction) {
            case northwest:
                return 0;
            case west:
                return 5;
            case southwest:
                return 4;
            case southeast:
                return 3;
            case east:
                return 2;
            case northeast:
                return 1;
        }
        return 0;
    }

    public static Direction toDirection(int i) {
        switch(i) {
            case 0:
                return northwest;
            case 1:
                return northeast;
            case 2:
                return east;
            case 3:
                return southeast;
            case 4:
                return southwest;
            case 5:
                return west;
        }
        return northeast;
    }

    public static Direction toDirection(String s) {
        for(Direction d : Direction.getSet()) {
            if(d.toString().equals(s)) {
                return d;
            }
        }
        return Direction.southwest;
    }

    public static int neededRightTurns(Direction from, Direction to) {
        if(Direction.toInt(from) <= Direction.toInt(to)) {
            return Direction.toInt(to) - Direction.toInt(from);
        }
        return 6 - Direction.toInt(from) + Direction.toInt(to);
    }

    public static int neededRightTurns(Direction to) {
        return Direction.neededRightTurns(northwest, to);
    }

}

