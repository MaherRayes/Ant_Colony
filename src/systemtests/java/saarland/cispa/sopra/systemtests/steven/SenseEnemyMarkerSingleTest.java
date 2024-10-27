package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class SenseEnemyMarkerSingleTest extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
	            ".A\n" +
	            ".B";
	        String brainB = "brain \"sample\" {\njump 1\n"
	        		+ "sense ahead marker 0 else 3\nset 0\njump 3\n}";//9
	        String brainA = "brain \"sample\" {\nmark 0\nmark 1\nmark 2\nmark 3\nmark 4\nmark 5\nmark 6\njump 0\n}";
	        WorldInfo world = gameInfo.simulate(21, 42, map, brainA, brainB);
	        if(world.getAnt(1).getRegister()[0]) {
	        	fail("Ant 1 from B was able to read swarm As markers!");
	        }
	 }
}

