package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class FieldEmptyAfterMove extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
    	String mapEmpty = "2\n2\n" +
	            "..\n" +
	            "AB";
	        String brainBEmpty = "brain \"sample\" {\nmove else 0\njump 0\n}";
	        String brainAEmpty = "brain \"sample\" {\nturn left\njump 0\n}";
	        WorldInfo world = gameInfo.simulate(1, 42, mapEmpty, brainAEmpty, brainBEmpty);
	        if(world.getFieldAt(1, 1).getAnt().isPresent()) {
	        	fail("Ant was nor removed after moving away from the field");
	        }
    }
}

