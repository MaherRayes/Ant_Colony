package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class MarkSameField extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            "AB\n" +
            "..";
        String brainA = "brain \"sample\" {\nmark 0\nmark 1\n mark 2\nmark 3\n mark 4\n mark 5\n mark 6\n move else 0\njump 8\n}";
        String brainB = "brain \"sample\" {\nturn left\njump 2\njump 3\njump 4\njump 5\njump 6\njump 7\njump 8\nmove else 1\nmark 0\nmark 1\n mark 2\nmark 3\n mark 4\n mark 5\n mark 6\njump 16\n}";
        WorldInfo world = gameInfo.simulate(30, 42, map, brainA, brainB);
        for(Boolean b : world.getFieldAt(0, 0).getMarkers().get('A')) {
        	if(!b) {
        		fail("Markers for ant 0 do not exist!");
        	}
        }
        for(Boolean b : world.getFieldAt(0, 0).getMarkers().get('B')) {
        	if(!b) {
        		fail("Markers for ant 1 do not exist!");
        	}
        }
    }
}
