package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class Move2x2Test extends SystemTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//northwest
		String map = "2\n2\n" +
	            "..\n" +
	            "AB";
	        String brainB = "brain \"sample\" {\nmove else 1\njump 0\n}";
	        String brainA = "brain \"sample\" {\nmove else 1\njump 0\n}";
	        WorldInfo world = gameInfo.simulate(1, 42, map, brainA, brainB);

	        if(world.getAnt(1).getField().getX()!=1) {
	        	if(world.getAnt(1).getField().getY()!=0) {
	        		fail("Ant 1 was not at 1,0 but at: !"+ world.getAnt(1).getField().toString());
	        	}
	        }
	        if(world.getAnt(0).getField().getX()!=0) {
	        	if(world.getAnt(0).getField().getY()!=0) {
	        		fail("Ant 0 was not at 0,0 but at: !"+ world.getAnt(0).getField().toString());
	        	}
	        }

	    //northeast
		String map2 = "2\n2\n" +
		           	  "..\n" +
		           	  "AB";
		String brainB2 = "brain \"sample\" {\nturn right\nmove else 1\njump 0\n}";
		String brainA2 = "brain \"sample\" {\nturn right\nmove else 1\njump 0\n}";
		WorldInfo world2 = gameInfo.simulate(2, 42, map2, brainA2, brainB2);
        if(world2.getAnt(1).getField().getX()!=0) {
        	if(world2.getAnt(1).getField().getY()!=0) {
        		fail("Ant 1 was not at 0,0 but at: !"+ world2.getAnt(1).getField().toString());
        	}
        }
        if(world2.getAnt(0).getField().getX()!=1) {
        	if(world2.getAnt(0).getField().getY()!=0) {
        		fail("Ant 0 was not at 1,0 but at: !"+ world2.getAnt(0).getField().toString());
        	}
        }

      //east
      		String map3 = "2\n2\n" +
      		           	  "A.\n" +
      		           	  "B.";
      		String brainB3 = "brain \"sample\" {\nturn right\nturn right\nmove else 1\njump 0\n}";
      		String brainA3 = "brain \"sample\" {\nturn right\nturn right\nmove else 1\njump 0\n}";
      		WorldInfo world3 = gameInfo.simulate(3, 42, map3, brainA3, brainB3);
              if(world3.getAnt(1).getField().getX()!=1) {
              	if(world3.getAnt(1).getField().getY()!=1) {
              		fail("Ant 1 was not at 1,1 but at: !"+ world3.getAnt(1).getField().toString());
              	}
              }
              if(world3.getAnt(0).getField().getX()!=1) {
              	if(world3.getAnt(0).getField().getY()!=0) {
              		fail("Ant 0 was not at 1,0 but at: !"+ world3.getAnt(0).getField().toString());
              	}
              }
              pmdForcedMeToDoThis(gameInfo);
	}
             private void pmdForcedMeToDoThis(GameInfo gameInfo) {
            	 //southeast
                 String map4 = "2\n2\n" +
           		           	  "AB\n" +
           		           	  "..";
           		String brainB4 = "brain \"sample\" {\nturn right\nturn right\nturn right\nmove else 1\njump 0\n}";
           		String brainA4 = "brain \"sample\" {\nturn right\nturn right\nturn right\nmove else 1\njump 0\n}";
           		WorldInfo world4 = gameInfo.simulate(4, 42, map4, brainA4, brainB4);
                   if(world4.getAnt(1).getField().getX()!=1) {
                   	if(world4.getAnt(1).getField().getY()!=1) {
                   		fail("Ant 1 was not at 1,1 but at: !"+ world4.getAnt(1).getField().toString());
                   	}
                   }
                   if(world4.getAnt(0).getField().getX()!=0) {
                   	if(world4.getAnt(0).getField().getY()!=1) {
                   		fail("Ant 0 was not at 0,1 but at: !"+ world4.getAnt(0).getField().toString());
                   	}
                   }

                 //southwest
                 String map5 = "2\n2\n" +
         		           	  "AB\n" +
         		           	  "..";
         		String brainB5 = "brain \"sample\" {\nturn right\nturn right\nturn right\nturn right\nmove else 1\njump 0\n}";
         		String brainA5 = "brain \"sample\" {\nturn right\nturn right\nturn right\nturn right\nmove else 1\njump 0\n}";
         		WorldInfo world5 = gameInfo.simulate(5, 42, map5, brainA5, brainB5);
               if(world5.getAnt(1).getField().getX()!=0) {
               	if(world5.getAnt(1).getField().getY()!=1) {
               		fail("Ant 1 was not at 0,1 but at: !"+ world5.getAnt(1).getField().toString());
               	}
               }
               if(world5.getAnt(0).getField().getX()!=1) {
               	if(world5.getAnt(0).getField().getY()!=1) {
               		fail("Ant 0 was not at 1,1 but at: !"+ world5.getAnt(0).getField().toString());
               	}
               }

               //west
               String map6 = "2\n2\n" +
                    	  ".A\n" +
                    	  ".B";
               String brainB6 = "brain \"sample\" {\nturn right\nturn right\nturn right\nturn right\nturn right\nmove else 1\njump 0\n}";
               String brainA6 = "brain \"sample\" {\nturn right\nturn right\nturn right\nturn right\nturn right\nmove else 1\njump 0\n}";
               WorldInfo world6 = gameInfo.simulate(6, 42, map6, brainA6, brainB6);
               if(world6.getAnt(1).getField().getX()!=0) {
             	  if(world6.getAnt(1).getField().getY()!=1) {
             		  fail("Ant 1 was not at 0,1 but at: !"+ world6.getAnt(1).getField().toString());
             	  }
               }
               if(world6.getAnt(0).getField().getX()!=0) {
             	  if(world6.getAnt(0).getField().getY()!=0) {
             		  fail("Ant 0 was not at 0,0 but at: !"+ world6.getAnt(0).getField().toString());
             	  }
               }
             }
}

