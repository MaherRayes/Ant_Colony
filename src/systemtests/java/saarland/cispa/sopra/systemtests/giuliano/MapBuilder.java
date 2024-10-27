package saarland.cispa.sopra.systemtests.giuliano;

public class MapBuilder {

    private int width;
    private int height;
    private int shownWidth;
    private int shownHeight;
    private char[][] map;

    public MapBuilder(int width, int height) {
        if(width <= 0 || height <= 0 || width % 2 != 0 || height % 2 != 0) {
            this.width = 0;
            this.height = 0;
        } else {
            this.width = width;
            this.height = height;
        }
        shownWidth = this.width;
        shownHeight = this.height;
        map = new char[width][height];
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                map[i][j] = '.';
            }
        }
    }

    public MapBuilder set(int x, int y, char c) {
        map[x][y] = c;
        return this;
    }

    public MapBuilder setEverything(char c) {
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                set(i,j,'#');
            }
        }
        return this;
    }

    public char get(int x, int y) {
        return map[x][y];
    }

    public String export() {
        StringBuilder sb = new StringBuilder();
        sb.append(shownWidth).append('\n').append(shownHeight);
        for(int i = 0; i < height; i++) {
            sb.append('\n');
            for(int j = 0; j < width; j++) {
                sb.append(map[j][i]);
            }
        }
        return sb.toString();
    }

    public MapBuilder setShownWidth(int shownWidth) {
        this.shownWidth = shownWidth;
        return this;
    }

    public MapBuilder setShownHeight(int shownHeight) {
        this.shownHeight = shownHeight;
        return this;
    }
}
