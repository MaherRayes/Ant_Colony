package saarland.cispa.sopra.systemtests.giuliano.program;

public class InvalidCaseTest extends SimpleProgramTest {
    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public String failMessage() {
        return "All instructions must be lower case.";
    }

    @Override
    public String getBrain() {
        return generateBrain("MARK 0", "UNMARK 0", "SET 0", "UNSET 0", "TEST 0 ELSE 0", "TURN RIGHT", "TURN LEFT", "MOVE ELSE 0", "SENSE HERE ROCK ELSE 0", "DROP ELSE 0", "DIRECTION EAST ELSE 0", "JUMP 0");
    }
}
