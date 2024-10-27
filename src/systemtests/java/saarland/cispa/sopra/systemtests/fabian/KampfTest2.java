package saarland.cispa.sopra.systemtests.fabian;

import saarland.cispa.sopra.systemtests.GameInfo;

import java.util.NoSuchElementException;

public class KampfTest2 extends BaseTest {

	@Override
	protected void test(GameInfo gameInfo) {
		//Von unterschiedlichen Teams umgeben
				String map =
						"2\n"
						+ "2\n"
						+ "AB\n"
						+ "CD\n";
				var world = gameInfo.simulate(2, 01, map, getBrainMove(), getUselessBrain(), getUselessBrain(), getUselessBrain());
				expect(NoSuchElementException.class, ()-> world.getAnt(0));
				world.getAnt(1);
				world.getAnt(2);
				world.getAnt(3);

	}

}
