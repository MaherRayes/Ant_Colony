package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

import java.util.NoSuchElementException;

public class CheckAllAntsMap extends SystemTest{

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n" +
	            	 "AA\n"
	            	 +"BB";
		String brain = "brain \"sample\" {\nturn left\njump 0\n}";
		WorldInfo world = gameInfo.simulate(1, 42, map, brain, brain);
		int oldId = world.getFieldAt(0, 0).getAnt().get().getId();
		boolean flag = false;
        for(int x=0; x<2;x++) {
        	for(int y=0;y<2;y++) {
        		try {
        			world.getFieldAt(x, y).getAnt();
        		}catch(NoSuchElementException e) {
        			fail("Not on every base field is an ant located initially!");
        		}
        		if(flag) {
        			if(oldId==world.getFieldAt(x, y).getAnt().get().getId()) {
        				fail("An ID has been assigned twice to an ant!");
        			}
        		}
        		else {
        			flag = true;
        		}
        	}
        }



	}

}
