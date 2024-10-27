package saarland.cispa.sopra.systemtests.giuliano.program;

public class MissingBrainKeywordTest extends SimpleProgramTest {
    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public String failMessage() {
        return "The brain code has to start with \"brain\".";
    }

    @Override
    public String getBrain() {
        return "\"dummy\" {\njump0\n}";
    }
}
