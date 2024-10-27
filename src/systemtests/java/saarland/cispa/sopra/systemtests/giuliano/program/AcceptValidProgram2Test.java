package saarland.cispa.sopra.systemtests.giuliano.program;

public class AcceptValidProgram2Test extends SimpleProgramTest {
    @Override
    public boolean valid() {
        return true;
    }

    @Override
    public String failMessage() {
        return "Programs that use any amount of whitespaces between words are allowed.";
    }

    @Override
    public String getBrain() {
        return generateBrain("jump 0\r\n\t", "jump 0");
    }
}
