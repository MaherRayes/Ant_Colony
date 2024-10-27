package saarland.cispa.sopra.systemtests.simon;


public class AntTestObject {

    private int id, xpos, ypos, pc;
    private String direction;
    private final boolean testPos;
    private final boolean testPc;
    private final boolean testDir;
    private boolean checkFood;
    private boolean hasFood;
    private boolean checkRegisters;
    private boolean[] registers;
    private boolean checkRestTime;
    private int restTime;

    public AntTestObject(int id) {
        this.id = id;
        testDir = false;
        testPc = false;
        testPos = false;
    }

    public AntTestObject(int id, int pc) {
        this.id = id;
        this.pc = pc;

        testPos = false;
        testPc = true;
        testDir = false;
    }

    public AntTestObject(int id, int xpos, int ypos, int pc) {
        this.id = id;

        this.xpos = xpos;
        this.ypos = ypos;
        this.pc = pc;
        testPos = true;
        testPc = true;
        testDir = false;
    }

    public AntTestObject(int id, int xpos, int ypos, int pc, String direction) {
        this.id = id;
        this.xpos = xpos;
        this.ypos = ypos;
        this.pc = pc;
        this.direction = direction;

        testPos = true;
        testPc = true;
        testDir = true;
    }
    public AntTestObject(int id, int xpos, int ypos, String direction) {
        this.id = id;
        this.xpos = xpos;
        this.ypos = ypos;
        this.direction = direction;

        testPos = true;
        testPc = false;
        testDir = true;
    }


    public boolean isCheckFood() {
        return checkFood;
    }

    public boolean isHasFood() {
        return hasFood;
    }
    public AntTestObject withCheckFood(boolean has){
        checkFood = true;
        hasFood = has;
        return this;
    }
    public AntTestObject withCheckRegisters(boolean... registers){
        this.registers = registers.clone();
        checkRegisters = true;
        return this;
    }
    public AntTestObject withCheckRestTime(int restTime){
        this.restTime = restTime;
        checkRestTime = true;
        return this;
    }


    public boolean isCheckRestTime() {
        return checkRestTime;
    }

    public int getRestTime() {
        return restTime;
    }

    public boolean isCheckRegisters() {
        return checkRegisters;
    }

    public boolean[] getRegisters() {
        return registers.clone();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public boolean isTestDir() {
        return testDir;
    }

    public boolean isTestPc() {
        return testPc;
    }

    public boolean isTestPos() {
        return testPos;
    }

    public String getDirection() {
        return direction;
    }
}
