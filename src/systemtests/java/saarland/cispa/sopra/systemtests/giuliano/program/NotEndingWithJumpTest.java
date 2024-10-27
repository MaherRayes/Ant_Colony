package saarland.cispa.sopra.systemtests.giuliano.program;

public class NotEndingWithJumpTest extends SimpleProgramTest {

    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public String failMessage() {
        return "Program must end with a jump instruction.";
    }

    @Override
    public String getBrain() {
        return generateBrain("mark 0");
    }
}
