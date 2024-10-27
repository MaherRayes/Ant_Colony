package saarland.cispa.sopra.systemtests.simon.map;

import saarland.cispa.sopra.systemtests.simon.BaseTest;

public class Mapper {

    public char[][] map;
    private final int x, y;


    public Mapper(int x, int y) {
        this.x = x;
        this.y = y;
        map = new char[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                map[i][j] = '.';
            }
        }
    }

    public Mapper setField(int x, int y, char c) {
        map[x][y] = c;
        return this;
    }

    public int getMapSizeX() {
        return x;
    }

    public int getMapSizeY() {
        return y;
    }

    public String onlyMapString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                sb.append(map[j][i]);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public boolean compareToWorldInfo(BaseTest b) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (b.getWorldInfo().getFieldAt(i, j).getAnt().isPresent()) {
                    if (b.getWorldInfo().getFieldAt(i, j).getAnt().get().getSwarm() != map[i][j]) {
                        return false;
                    }
                } /*else if (b.getWorldInfo().getFieldAt(i, j).getType() != map[i][j]) {
                    return false;
                }*/
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return x + "\n" + y + "\n" + onlyMapString();
    }
}
