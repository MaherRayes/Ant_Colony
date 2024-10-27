package saarland.cispa.sopra.saarmeisen;

public enum Direction {
    northwest, northeast, east, southeast, southwest, west;

    public Direction getLeft() {
        return values()[(ordinal() + 5) % 6];
    }
    public Direction getRight() {
        return values()[(ordinal() + 1) % 6];
    }

}


