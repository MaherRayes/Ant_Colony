package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;


public class TorusSenseMarkerTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
    	String map = "2\n2\n" +
	            "AA\n" +
	            "BB";

	        String brainB = "brain \"sample\" {\nmark 0\nmark 1\nmark 2\nmark 3\n mark 4\nmark 5\nmark 6\njump 0\n}"; //0-7
	        String brainA = "brain \"sample\" {\nmark 0\nmark 1\nmark 2\nmark 3\n mark 4\nmark 5\nmark 6\n" //0-6
	        					+ "sense ahead marker 0 else 9\njump 43\n" //7-8
	        					+ "sense ahead marker 1 else 11\njump 43\n" //9-10
	        					+ "sense ahead marker 2 else 13\njump 43\n"//11-12
	        					+ "sense ahead marker 3 else 15\njump 43\n"//13-14
	        					+ "sense ahead marker 4 else 17\njump 43\n"//15-16
	        					+ "sense ahead marker 5 else 19\njump 43\n"//17-18
	        					+ "sense ahead marker 6 else 21\njump 43\n"//19-20

	        					+ "sense right marker 0 else 23\njump 43\n"//21-22
	        					+ "sense right marker 1 else 25\njump 43\n"//23-24
	        					+ "sense right marker 2 else 27\njump 43\n"//25-26
	        					+ "sense right marker 3 else 29\njump 43\n"//27-28
	        					+ "sense right marker 4 else 31\njump 43\n"//29-30
	        					+ "sense right marker 5 else 33\njump 43\n"//31-32
	        					+ "sense right marker 6 else 35\njump 43\n"//33-34

	        					+ "sense left marker 0 else 43\n"//35
	        					+ "sense left marker 1 else 43\n"//36
	        					+ "sense left marker 2 else 43\n"//37
	        					+ "sense left marker 3 else 43\n"//38
	        					+ "sense left marker 4 else 43\n"//39
	        					+ "sense left marker 5 else 43\n"//40
	        					+ "sense left marker 6 else 43\n"//41

    							+ "jump 44\nturn left\njump 44\n}";  //42-44
	        WorldInfo world2 = gameInfo.simulate(20, 42, map, brainA, brainB);


	        if(!"northwest".equals(world2.getAnt(0).getDirection())) {
	        	fail("Cannot sense markers (ant 0) through map boundary!");
	        }
    }
}

