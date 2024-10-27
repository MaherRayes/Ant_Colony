package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.AntInfo;
import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class BrainTest1 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//Stimmt Hirnreihenfolge
		String map = getCheapMap();
		String brainA =
				"brain \"PcInOne\"{\n"
				+ "jump 1\n"
				+ "jump 1\n"
				+ "}";
		String brainB =
				"brain \"PcinTwo\"{\n"
				+ "jump 2\n"
				+ "jump 2\n"
				+ "jump 2\n"
				+ "}";
		WorldInfo world = gameInfo.simulate(10, 42, map, brainA, brainB);
		AntInfo antA = world.getAnt(0);
		AntInfo antB = world.getAnt(1);
		assertTrue ("Gehirne wurden vertauscht(oder IDs)", antA.getPc() == 1 && antB.getPc() == 2);

		//Stimmt Hirnanzahl
		String brain = getUselessBrain();
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(2, 42, map, brain));					//Ein Brain zu wenig
		expect(IllegalArgumentException.class, ()-> gameInfo.simulate(2, 42, map, brain, brain, brain));	//ein Brain zu viel
	}

}
