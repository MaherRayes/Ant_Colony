package saarland.cispa.sopra.saarmeisen.antlr;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import saarland.cispa.sopra.antlr.AcolaBaseListener;
import saarland.cispa.sopra.antlr.AcolaParser;
import saarland.cispa.sopra.saarmeisen.Direction;
import saarland.cispa.sopra.saarmeisen.instruction.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyAcolaListener extends AcolaBaseListener {

    private String name;
    private final List<Instruction> instructions;
    private final Random random;

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public String getName() {
        return name;
    }

    public MyAcolaListener(Random random) {
        this.instructions = new ArrayList<>();
        this.random = random;
    }

    //TODO Exception messages

    public int parseToInt(TerminalNode terminalNode) {
        try {
            return Integer.parseInt(terminalNode.getText());
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("error while parsing ing.", e);
        }
    }

    @Override
    public void exitBrain(AcolaParser.BrainContext ctx) {
        name = ctx.IDENTIFIER().getText();
    }

    @Override
    public void exitMark(AcolaParser.MarkContext ctx) {
        int index = parseToInt(ctx.NUMBER());
        instructions.add(new MarkInstruction(index,true));
    }

    @Override
    public void exitUnmark(AcolaParser.UnmarkContext ctx) {
        int index = parseToInt(ctx.NUMBER());
        instructions.add(new MarkInstruction(index,false));
    }

    @Override
    public void exitSet(AcolaParser.SetContext ctx) {
        int index = parseToInt(ctx.NUMBER());
        instructions.add(new SetInstruction(index,true));
    }
    @Override
    public void exitUnset(AcolaParser.UnsetContext ctx) {
        int index = parseToInt(ctx.NUMBER());
        instructions.add(new SetInstruction(index,false));
    }

    @Override
    public void exitTest(AcolaParser.TestContext ctx) {
        int failIndex = parseToInt(ctx.elsePart().NUMBER());
        int registerIndex = parseToInt(ctx.NUMBER());
        instructions.add(new TestInstruction(failIndex,registerIndex));
    }

    @Override
    public void exitTurn(AcolaParser.TurnContext ctx) {
        // TODO changed
        TurnDirection direction = TurnDirection.valueOf(ctx.RELATIVEDIRECTION().getText());
        instructions.add(new TurnInstruction(direction));
    }


    @Override
    public void exitMove(AcolaParser.MoveContext ctx) {
        int failIndex = parseToInt(ctx.elsePart().NUMBER());
        instructions.add(new MoveInstruction(failIndex));
    }


    @Override
    public void exitSense(AcolaParser.SenseContext ctx) {
        int failIndex = parseToInt(ctx.elsePart().NUMBER());
        SensableObject sensableObject;
        RelativeDirection direction = RelativeDirection.valueOf(ctx.RELATIVEDIRECTION().getText());
        if(ctx.markerSense() == null) {
            sensableObject = SensableObject.valueOf(ctx.SENSEABLE().getText());
            instructions.add(new SenseInstruction(failIndex,sensableObject,direction));
        } else {
            int markerIndex = parseToInt(ctx.markerSense().NUMBER());
            sensableObject = SensableObject.marker;
            instructions.add(new SenseInstruction(failIndex,sensableObject,direction,markerIndex));
        }
    }


    @Override
    public void exitPickup(AcolaParser.PickupContext ctx) {
        int failIndex = parseToInt(ctx.elsePart().NUMBER());
        instructions.add(new PickupInstruction(failIndex));
    }

    @Override
    public void exitDrop(AcolaParser.DropContext ctx) {
        int failIndex = parseToInt(ctx.elsePart().NUMBER());
        instructions.add(new DropInstruction(failIndex));
    }

    @Override
    public void exitFlip(AcolaParser.FlipContext ctx) {
        int failIndex = parseToInt(ctx.elsePart().NUMBER());
        int max = parseToInt(ctx.NUMBER());
        instructions.add(new FlipInstruction(failIndex,random,max));
    }
    @Override
    public void exitJump(AcolaParser.JumpContext ctx) {
        int failIndex = parseToInt(ctx.NUMBER());
        instructions.add(new JumpInstruction(failIndex));
    }
    @Override
    public void exitDirection(AcolaParser.DirectionContext ctx) {
        int failIndex = parseToInt(ctx.elsePart().NUMBER());
        Direction direction = Direction.valueOf(ctx.DIRECTION().getText());
        instructions.add(new DirectionInstruction(failIndex,direction));
    }
    @Override
    public void visitErrorNode(ErrorNode node) {
        throw new IllegalArgumentException("Brain parser error. Node=" + node.toString());
    }
    @Override
    public void exitBreed(AcolaParser.BreedContext ctx) {
        int failIndex = parseToInt(ctx.elsePart().NUMBER());
        instructions.add(new BreedInstruction(failIndex));
    }

}
