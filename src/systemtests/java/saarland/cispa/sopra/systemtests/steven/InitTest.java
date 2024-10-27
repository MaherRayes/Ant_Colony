package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;

public class InitTest extends SystemTest {
	private final static String northwest = "northwest";

	private final static String brain = "brain \"nothing\" {\njump 0\n}";
	private final static String map = "4\n4\n"
									+"A...\n"
									+"B...\n"
									+ "1...\n"
									+ "#...";

	private void testInitPosAnts(WorldInfo world) {
		if(world.getAnt(0).getField().getX()!=0 && world.getAnt(0).getField().getY()!=0) {
			fail("The initial Position of Ant 0 was not 0,0 but: "+world.getAnt(0).getField().toString());
		}
		if(world.getAnt(1).getField().getX()!=0 && world.getAnt(1).getField().getY()!=1) {
			fail("The initial Position of Ant 1 was not 0,1 but: "+world.getAnt(0).getField().toString());
		}
	}

	private void testInitDirection(WorldInfo world) {
		if(!northwest.equals(world.getAnt(0).getDirection())) {
			fail("Initial Direction of the Ants is not set to northwest, but: "+world.getAnt(0).getDirection());
		}
		if(!northwest.equals(world.getAnt(1).getDirection())) {
			fail("Initial Direction of the Ants is not set to northwest, but: "+world.getAnt(1).getDirection());
		}
	}
	private void testInitFood(WorldInfo world) {
		if(world.getFieldAt(0, 2).getFood()!=1) {
			fail("Food amount on 0,3 was expected to be 1, but was: "+world.getFieldAt(0, 2).getFood());
		}
		if(world.getAnt(0).hasFood()) {
			fail("Ant 0 has initially food!");
		}
		if(world.getAnt(1).hasFood()) {
			fail("Ant 1 has initially food!");
		}
	}
	private void testInitObstacle(WorldInfo world) {
		if(world.getFieldAt(0, 3).getType()!='#') {
			fail("Expected an obstacle field at 0,3, but was: "+world.getFieldAt(0, 3).getType());
		}
	}
	private void testInitBase(WorldInfo world) {
		if(world.getFieldAt(0, 0).getType()!='A') {
			fail("Expected base A at 0,0, but was: "+world.getFieldAt(0, 0).getType());
		}
		if(world.getFieldAt(0, 1).getType()!='B') {
			fail("Expected base A at 0,1, but was: "+world.getFieldAt(0, 1).getType());
		}
	}
	private void testInitScore(WorldInfo world) {
		if(world.getScore('A')!=0) {
			fail("Initial score is not 0 for swarm A!");
		}
		if(world.getScore('B')!=0) {
			fail("Initial score is not 0 for swarm B!");
		}
	}
	private void testInitRegisters(WorldInfo world) {
		for(Boolean b : world.getAnt(0).getRegister()) {
			if(b) {
				fail("Register initially is not false!");
			}
		}
		for(Boolean b : world.getAnt(1).getRegister()) {
			if(b) {
				fail("Register initially is not false!");
			}
		}
	}
	private void testInitPC(WorldInfo world) {
		if(world.getAnt(0).getPc()!=0) {
			fail("initial PC is not 0!");
		}
		if(world.getAnt(1).getPc()!=0) {
			fail("initial PC is not 0!");
		}
	}
	private void testInitAntList(WorldInfo world) {
		if(world.getAnts().size()!=2) {
			fail("The initial list does not contain 2 ants!");
		}
	}
	private void testInitRestTime(WorldInfo world) {
		if(world.getAnt(0).getRestTime()!=0) {
			fail("The initial rest time is not 0!");
		}
		if(world.getAnt(1).getRestTime()!=0) {
			fail("The initial rest time is not 0!");
		}
	}
	private void testInitMarkers(WorldInfo worldInfo) {
		for(int x = 0; x<4; x++) {
			for(int y=0;y<4;y++) {
				for(Boolean b: worldInfo.getFieldAt(x, y).getMarkers().get('A')) {
					if(b) {
						fail("Markers are not initially false!");
					}
				}
				for(Boolean b: worldInfo.getFieldAt(x, y).getMarkers().get('B')) {
					if(b) {
						fail("Markers are not initially false!");
					}
				}
			}
		}
	}
	private void testInitSwarm(WorldInfo worldInfo) {
		if(worldInfo.getAnt(0).getSwarm()!='A') {
			fail("Ant 0 does not belong to swarm A!");
		}
		if(worldInfo.getAnt(1).getSwarm()!='B') {
			fail("Ant 0 does not belong to swarm B!");
		}

	}
    @Override
    public void test(GameInfo gameInfo) {
    	WorldInfo world = gameInfo.simulate(0, 42, map, brain, brain);
    	testInitPosAnts(world);
    	testInitDirection(world);
    	testInitFood(world);
    	testInitObstacle(world);
    	testInitBase(world);
    	testInitScore(world);
    	testInitRegisters(world);
    	testInitPC(world);
    	testInitAntList(world);
    	testInitRestTime(world);
    	this.testInitMarkers(world);
    	testInitSwarm(world);
    	if(world.getHeight()!=4) {
    		fail("Height is not as it was in map string!");
    	}
    	if(world.getWidth()!=4) {
    		fail("Height is not as it was in map string!");
    	}
    	expect(NoSuchElementException.class, ()-> world.getAnt(-1));
    }
}
