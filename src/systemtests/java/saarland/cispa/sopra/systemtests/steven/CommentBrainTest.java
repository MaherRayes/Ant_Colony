package saarland.cispa.sopra.systemtests.steven;


import saarland.cispa.sopra.systemtests.GameInfo;
import saarland.cispa.sopra.systemtests.SystemTest;
import saarland.cispa.sopra.systemtests.WorldInfo;

public class CommentBrainTest extends SystemTest {
    @Override
    public void test(GameInfo gameInfo) {
        String map = "2\n2\n" +
            ".A\n" +
            ".B\n";

        String brainB = "brain \"sample\" {\nturn right\njump 0\n}";
        String brainSlash = "brain \"sample\" {\nturn right//turn left\njump 0\n}"; //direction has to be northeast
        String brainComment = "brain \"sample\" {\n/*turn left\n turn left*/turn right\njump 0\n}"; //direction has to be northeast
        String brainError = "brain \"sample\" {\n/*turn left\n turn left\nturn right\njump 0\n}";
        WorldInfo worldSlash = gameInfo.simulate(2, 42, map, brainSlash, brainB);
        WorldInfo worldComment = gameInfo.simulate(2, 42, map, brainComment, brainB);
        expect(IllegalArgumentException.class, () -> gameInfo.simulate(2, 42, map, brainError, brainB));
        if(!"northeast".equals(worldSlash.getAnt(0).getDirection())) {
        	fail("Comment (one line comment) has been used as instruction!");
        }
        if(!"northeast".equals(worldComment.getAnt(0).getDirection())) {
        	fail("Comment (multi line comment) has been used as instruction!");
        }
    }
}
