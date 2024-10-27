package saarland.cispa.sopra.systemtests.giuliano.program;

public class ValidFlipParameterTest extends SimpleProgramTest {
    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public String failMessage() {
        return "All non negative flip parameters are allowed";
    }

    @Override
    public String getBrain() {
        return generateBrain("flip 0 else 0", "jump 0");
    }
}
