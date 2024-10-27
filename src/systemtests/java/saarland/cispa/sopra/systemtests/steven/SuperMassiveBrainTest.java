package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;

public class SuperMassiveBrainTest extends SystemTest{

	@Override
	protected void test(GameInfo gameInfo) {
		String map = "2\n2\n"
				+ "B."
				+ ".A";
		String brain = "brain \"mark\" {\nturn left\njump 0\n}";
		StringBuilder b = new StringBuilder(16700);
		String instruction = "\njump 0";
		b.append("brain \"mark\" {");
		for(int x= 0; x<=2500;x++) {
			b.append(instruction);
		}

		b.append("\n}");
        // gameInfo gibt einen Snapshot der Welt nach Runde 1 zurück
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(1, 42, map, b.toString(), brain));

	}

}
