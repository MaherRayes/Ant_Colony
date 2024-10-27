import org.junit.jupiter.api.Test;
import saarland.cispa.sopra.saarmeisen.Program;
import saarland.cispa.sopra.saarmeisen.antlr.ProgramParser;
import saarland.cispa.sopra.saarmeisen.instruction.Instruction;

import java.util.Random;

public class AntlrDebug {

    @Test
    public void test() {
        String brain;
        brain = "brain\n" + "\"ant\"\n" + "{\n" + "//*/*/\njump 0/*\n" + "*/}";
        ProgramParser pp = new ProgramParser();
        pp.parseProgram(brain, new Random(0), 'A');
    }

    @Test
    public void test2() {
        System.out.println(filterString("/*hall\nooo*/   /*oa\nk*/"));
        String brain1 =
            "brain \"DerSetter\"{\n"
                + "set 2\n"
                + "test 2 else 4\n"
                + "unset 2\n"
                + "test 2 else 5\n"
                + "jump 4\n"	//Fehler
                + "jump 5\n"	//Erfolg
                + "}";
        brain1 = "brain \"hello\" {sense ahead marker 5 else 0 /*hello*/ \n" +
            "jump 0/*hell\no*/" +
            "jump 1\n}//\n/*.*/";
        brain1 = //Andere Klammer vergessen
            "brain \"Klammerhater\"{\n"
                + "jump 0\n";
        //brain1 = "brain \"name\" {\nmove /*tree*/ else /*dark oak*/ 3\njump 0\n";
        brain1 = "brain \"hello\" {sense ahead marker 5 else 0 /*hello*/ \n" +
            "jump 0/*hell\no*/" +
            "jump 1\n}//\n/*.*/";
        brain1= "brain /*sdjf*/ \"dsf\" { //kjdbfsdfui\n" + "                   \n" + "                   /*sdfsdf*/\n" + "                   \n"
            + "                   jump 0 //dsfhsdfuhsd\n" + "}";
        brain1 = "brain/**/\"ant\"/**/{jump/**/0\n" + "}";
        brain1 = "brain \"ant\" {jump 0\n" + "}";
        brain1 = "brain \"ant\" {jump/*\\u2345\\u2124\\u4531\\u1345*/0\n" + "}";
        brain1 = "brain \n" + "\"ant\" \n" + "{\t\n" + "jump 0\n" + "}\n" + "\n" + "\n" + "//\\u2345\\u1344\n";
        brain1 = "brain\n" + "\"ant\"\n" + "{\n" + "jump 0//\\u5413\n" + "}";
        brain1 = "brain\n" + "\"ant\"\n" + "{\n" + "jump 0/*\n" + "*/}";
        brain1 = "brain\n" + "\"ant\"\n" + "{\n" + "//*/*/\njump 0/*\n" + "*/}";
        brain1 = "brain \"yakuza\" {\n" +
            "\tset 1                               \n" +
            "\ttest 1 else 4                //target: @findFood //label: @begin\n" +
            "\ttest 2 else 177               //target: @bringHome\n" +
            "\tjump  179         //target: @followMarkerHomeNoFood\n" +
            "\tflip 3 else 6  //target: @begin//BOM: #setDirRandom //label: @begin //BOM: #findFoodNoMarker //label: @findFood\n" +
            "\tjump  10\n" +
            "\tflip 2 else 9\n" +
            "\tturn left\n" +
            "\tjump  10\n" +
            "\tturn right\n" +
            "\tjump 11   //target: @return//target: @return//target: @return // EOM: #setDirRandom\n" +
            "\tsense ahead antlion else 13 //label: @checkForAntLion //BOM: #safe_dir\n" +
            "\tturn left\n" +
            "\tjump  11 //target: @checkForAntLion\n" +
            "\tsense ahead foehome else 16 //label: @checkForFoehome\n" +
            "\tturn left\n" +
            "\tjump 11 //target: @checkForAntLion\n" +
            "\tsense left foe else 18 //label: @checkForEnemy\n" +
            "\tsense right foe else 21\n" +
            "\tturn left\n" +
            "\tjump  11 //target: @checkForAntLion // EOM: #safe_dir\n" +
            "\tunset 1 //BOM: #setDirUnexplored\n" +
            "\tunset 4\n" +
            "\tunset 5\n" +
            "\tsense ahead marker 0 else 31   //target: @begin//target: @begin//target: @changeDir //label: @begin\n" +
            "\tsense ahead marker 1 else 31 //target: @changeDir\n" +
            "\tsense ahead marker 2 else 31 //target: @changeDir\n" +
            "\tsense ahead marker 3 else 31 //target: @changeDir\n" +
            "\tsense ahead marker 4 else 31 //target: @changeDir\n" +
            "\tsense ahead marker 5 else 31 //target: @changeDir\n" +
            "\tjump  36   //target: @return//target: @return//target: @return\n" +
            "\tturn left //label: @changeDir\n" +
            "\tflip 50 else 24   //target: @begin//target: @begin//target: @begin\n" +
            "\tjump  35 //target: @cycleBreak\n" +
            "\tjump  24   //target: @begin//target: @begin//target: @begin\n" +
            "\tunset 1 //label: @cycleBreak // EOM: #setDirUnexplored\n" +
            "\ttest 1 else 105 //target: @cycleDone\n" +
            "\tdirection northwest else 42 //target: @northeast //label: @northwest //BOM: #markMovingTo\n" +
            "\tunmark 0\n" +
            "\tmark 1\n" +
            "\tmark 2\n" +
            "\tjump 66   //target: @return//target: @return//target: @return\n" +
            "\tdirection northeast else 47 //target: @east //label: @northeast\n" +
            "\tunmark 0\n" +
            "\tmark 1\n" +
            "\tunmark 2\n" +
            "\tjump 66   //target: @return//target: @return//target: @return\n" +
            "\tdirection east else 52 //target: @southeast //label: @east\n" +
            "\tunmark 0\n" +
            "\tmark 1\n" +
            "\tmark 2\n" +
            "\tjump 66   //target: @return//target: @return//target: @return\n" +
            "\tdirection southeast else 57 //target: @southwest //label: @southeast\n" +
            "\tmark 0\n" +
            "\tunmark 1\n" +
            "\tunmark 2\n" +
            "\tjump 66   //target: @return//target: @return//target: @return\n" +
            "\tdirection southwest else 62 //target: @west //label: @southwest\n" +
            "\tmark 0\n" +
            "\tunmark 1\n" +
            "\tmark 2\n" +
            "\tjump 66   //target: @return//target: @return//target: @return\n" +
            "\tmark 0 //label: @west\n" +
            "\tmark 1\n" +
            "\tunmark 2\n" +
            "\tjump 66   //target: @return//target: @return//target: @return // EOM: #markMovingTo\n" +
            "\tmove else 4  //target: @begin//target: @begin\n" +
            "\tdirection southeast else 72 //target: @northeast //label: @northwest //BOM: #markMovedFrom\n" +
            "\tunmark 3\n" +
            "\tunmark 4\n" +
            "\tmark 5\n" +
            "\tjump 96   //target: @return//target: @return//target: @return\n" +
            "\tdirection southwest else 77 //target: @east //label: @northeast\n" +
            "\tunmark 3\n" +
            "\tmark 4\n" +
            "\tunmark 5\n" +
            "\tjump 96   //target: @return//target: @return//target: @return\n" +
            "\tdirection west else 82 //target: @southeast //label: @east\n" +
            "\tunmark 3\n" +
            "\tmark 4\n" +
            "\tmark 5\n" +
            "\tjump 96   //target: @return//target: @return//target: @return\n" +
            "\tdirection northwest else 87 //target: @southwest //label: @southeast\n" +
            "\tmark 3\n" +
            "\tunmark 4\n" +
            "\tunmark 5\n" +
            "\tjump 96   //target: @return//target: @return//target: @return\n" +
            "\tdirection northeast else 92 //target: @west //label: @southwest\n" +
            "\tmark 3\n" +
            "\tunmark 4\n" +
            "\tmark 5\n" +
            "\tjump 96   //target: @return//target: @return//target: @return\n" +
            "\tmark 3 //label: @west\n" +
            "\tmark 4\n" +
            "\tunmark 5\n" +
            "\tjump 96   //target: @return//target: @return//target: @return // EOM: #markMovedFrom\n" +
            "\tpickup else 98   //target: @return//target: @return//target: @return //BOM: #checkFoodAndPickup\n" +
            "\tjump 98   //target: @return//target: @return//target: @return // EOM: #checkFoodAndPickup\n" +
            "\tsense here friendfood else 4  //target: @begin//target: @begin\n" +
            "\tsense here food else 102 //target: @setLastFoodState\n" +
            "\tunset 1\n" +
            "\tjump 177  //target: @return//target: @return\n" +
            "\tset 2 //label: @setLastFoodState\n" +
            "\tunset 1\n" +
            "\tjump 177  //target: @return//target: @return\n" +
            "\tsense here marker 0 else 110   //target: @begin//target: @begin//target: @state1 //label: @setDirectionWithMarkerFollowToFood //BOM: #interpretMarkerFood //label: @begin //BOM: #followMarkerToFood //label: @cycleDone\n" +
            "\tsense here marker 1 else 114 //target: @state2\n" +
            "\tsense here marker 2 else 109\n" +
            "\tjump  157 //target: @setDirNoFoodLeft\n" +
            "\tjump  145 //target: @setDirWest\n" +
            "\tsense here marker 1 else 117 //target: @state3 //label: @state1\n" +
            "\tsense here marker 2 else 113\n" +
            "\tjump  130 //target: @setDirEast\n" +
            "\tjump  125 //target: @setDirNortheast\n" +
            "\tsense here marker 2 else 116 //label: @state2\n" +
            "\tjump  140 //target: @setDirSouthwest\n" +
            "\tjump  135 //target: @setDirSoutheast\n" +
            "\tsense here marker 2 else 119 //label: @state3\n" +
            "\tjump  120 //target: @setDirNorthwest\n" +
            "\tjump  150 //target: @setDirRandom\n" +
            "\tdirection northwest else 122 //label: @setDirNorthwest\n" +
            "\tjump  160     //target: @return//target: @return//target: @return//target: @return//target: @return\n" +
            "\tturn left\n" +
            "\tdirection northwest else 122\n" +
            "\tjump  159 //target: @done\n" +
            "\tdirection northeast else 127 //label: @setDirNortheast\n" +
            "\tjump  159 //target: @done\n" +
            "\tturn left\n" +
            "\tdirection northeast else 127\n" +
            "\tjump  159 //target: @done\n" +
            "\tdirection east else 132 //label: @setDirEast\n" +
            "\tjump  159 //target: @done\n" +
            "\tturn left\n" +
            "\tdirection east else 132\n" +
            "\tjump  159 //target: @done\n" +
            "\tdirection southeast else 137 //label: @setDirSoutheast\n" +
            "\tjump  159 //target: @done\n" +
            "\tturn left\n" +
            "\tdirection southeast else 137\n" +
            "\tjump  159 //target: @done\n" +
            "\tdirection southwest else 142 //label: @setDirSouthwest\n" +
            "\tjump  159 //target: @done\n" +
            "\tturn left\n" +
            "\tdirection southwest else 142\n" +
            "\tjump  159 //target: @done\n" +
            "\tdirection west else 147 //label: @setDirWest\n" +
            "\tjump  159 //target: @done\n" +
            "\tturn left\n" +
            "\tdirection west else 147\n" +
            "\tjump  159 //target: @done\n" +
            "\tflip 3 else 152 //label: @setDirRandom\n" +
            "\tjump  159 //target: @done\n" +
            "\tflip 2 else 155\n" +
            "\tturn left\n" +
            "\tjump  159 //target: @done\n" +
            "\tturn right\n" +
            "\tjump  159 //target: @done\n" +
            "\tset 1 //label: @setDirNoFoodLeft\n" +
            "\tjump  150 //target: @setDirRandom\n" +
            "\tjump  160     //target: @return//target: @return//target: @return//target: @return//target: @return //label: @done // EOM: #interpretMarkerFood\n" +
            "\ttest 1 else 162 //target: @moreFood\n" +
            "\tjump  177    //target: @return//target: @return//target: @return//target: @return\n" +
            "\tsense ahead antlion else 165 //label: @checkForAntLion //BOM: #safe_dirWithFoehome //label: @moreFood\n" +
            "\tturn left\n" +
            "\tjump  162 //target: @checkForAntLion\n" +
            "\tsense ahead foehome else 168 //label: @checkForFoehome\n" +
            "\tturn left\n" +
            "\tjump 162 //target: @checkForAntLion\n" +
            "\tsense left foe else 172 //label: @checkForEnemy\n" +
            "\tsense right foe else 172\n" +
            "\tturn left\n" +
            "\tjump  162 //target: @checkForAntLion\n" +
            "\tjump 173     //target: @return//target: @return//target: @return//target: @return//target: @return // EOM: #safe_dirWithFoehome\n" +
            "\tmove else 105   //target: @begin//target: @begin//target: @begin\n" +
            "\tpickup else 175 //target: @pickupTest\n" +
            "\tsense here friendfood else 105   //target: @begin//target: @begin//target: @begin //label: @pickupTest\n" +
            "\tjump 177    //target: @return//target: @return//target: @return//target: @return // EOM: #followMarkerToFood // EOM: #findFoodNoMarker\n" +
            "\tsense here friendfood else 1    //target: @begin //label: @bringHome\n" +
            "\ttest 2 else 246        //target: @followMarkerHome\n" +
            "\ttest 2 else 183  //target: @begin//target: @notLastFood //label: @begin //BOM: #followMarkerToHome //label: @followMarkerHomeNoFood\n" +
            "\tmark 0\n" +
            "\tmark 1\n" +
            "\tmark 2\n" +
            "\tsense here marker 3 else 188 //target: @state1 //label: @setDirectionWithMarkerFollowToFood //BOM: #interpretMarkerHome //label: @notLastFood\n" +
            "\tsense here marker 4 else 192 //target: @state2\n" +
            "\tsense here marker 5 else 187\n" +
            "\tjump  235 //target: @setDirNoFoodLeft\n" +
            "\tjump  223 //target: @setDirWest\n" +
            "\tsense here marker 4 else 195 //target: @state3 //label: @state1\n" +
            "\tsense here marker 5 else 191\n" +
            "\tjump  208 //target: @setDirEast\n" +
            "\tjump  203 //target: @setDirNortheast\n" +
            "\tsense here marker 5 else 194 //label: @state2\n" +
            "\tjump  218 //target: @setDirSouthwest\n" +
            "\tjump  213 //target: @setDirSoutheast\n" +
            "\tsense here marker 5 else 197 //label: @state3\n" +
            "\tjump  198 //target: @setDirNorthwest\n" +
            "\tjump  228 //target: @setDirRandom\n" +
            "\tdirection northwest else 200 //label: @setDirNorthwest\n" +
            "\tjump  237   //target: @return//target: @return//target: @return\n" +
            "\tturn left\n" +
            "\tdirection northwest else 200\n" +
            "\tjump  237 //target: @done\n" +
            "\tdirection northeast else 205 //label: @setDirNortheast\n" +
            "\tjump  237 //target: @done\n" +
            "\tturn left\n" +
            "\tdirection northeast else 205\n" +
            "\tjump  237 //target: @done\n" +
            "\tdirection east else 210 //label: @setDirEast\n" +
            "\tjump  237 //target: @done\n" +
            "\tturn left\n" +
            "\tdirection east else 210\n" +
            "\tjump  237 //target: @done\n" +
            "\tdirection southeast else 215 //label: @setDirSoutheast\n" +
            "\tjump  237 //target: @done\n" +
            "\tturn left\n" +
            "\tdirection southeast else 215\n" +
            "\tjump  237 //target: @done\n" +
            "\tdirection southwest else 220 //label: @setDirSouthwest\n" +
            "\tjump  237 //target: @done\n" +
            "\tturn left\n" +
            "\tdirection southwest else 220\n" +
            "\tjump  237 //target: @done\n" +
            "\tdirection west else 225 //label: @setDirWest\n" +
            "\tjump  237 //target: @done\n" +
            "\tturn left\n" +
            "\tdirection west else 225\n" +
            "\tjump  237 //target: @done\n" +
            "\tflip 3 else 230 //label: @setDirRandom\n" +
            "\tjump  237 //target: @done\n" +
            "\tflip 2 else 233\n" +
            "\tturn left\n" +
            "\tjump  237 //target: @done\n" +
            "\tturn right\n" +
            "\tjump  237 //target: @done\n" +
            "\tset 1 //label: @setDirNoFoodLeft\n" +
            "\tjump  228 //target: @setDirRandom // EOM: #interpretMarkerHome\n" +
            "\tmove else 179  //target: @begin//target: @begin //label: @afterInterpret\n" +
            "\tsense here home else 242 //BOM: #checkFoodDropOnHome\n" +
            "\tdrop else 242\n" +
            "\tunset 0\n" +
            "\tjump 242   //target: @return//target: @return//target: @return // EOM: #checkFoodDropOnHome\n" +
            "\tsense here friendfood else return\n" +
            "\tjump  179  //target: @begin//target: @begin // EOM: #followMarkerToHome\n" +
            "\tsense here friendfood else 4                //target: @findFood\n" +
            "\tjump  177                      //target: @bringHome\n" +
            "\ttest 2 else 250  //target: @begin//target: @notLastFood //label: @begin //BOM: #followMarkerToHome //label: @followMarkerHome\n" +
            "\tmark 0\n" +
            "\tmark 1\n" +
            "\tmark 2\n" +
            "\tsense here marker 3 else 255 //target: @state1 //label: @setDirectionWithMarkerFollowToFood //BOM: #interpretMarkerHome //label: @notLastFood\n" +
            "\tsense here marker 4 else 259 //target: @state2\n" +
            "\tsense here marker 5 else 254\n" +
            "\tjump  302 //target: @setDirNoFoodLeft\n" +
            "\tjump  290 //target: @setDirWest\n" +
            "\tsense here marker 4 else 262 //target: @state3 //label: @state1\n" +
            "\tsense here marker 5 else 258\n" +
            "\tjump  275 //target: @setDirEast\n" +
            "\tjump  270 //target: @setDirNortheast\n" +
            "\tsense here marker 5 else 261 //label: @state2\n" +
            "\tjump  285 //target: @setDirSouthwest\n" +
            "\tjump  280 //target: @setDirSoutheast\n" +
            "\tsense here marker 5 else 264 //label: @state3\n" +
            "\tjump  265 //target: @setDirNorthwest\n" +
            "\tjump  295 //target: @setDirRandom\n" +
            "\tdirection northwest else 267 //label: @setDirNorthwest\n" +
            "\tjump  304   //target: @return//target: @return//target: @return\n" +
            "\tturn left\n" +
            "\tdirection northwest else 267\n" +
            "\tjump  304 //target: @done\n" +
            "\tdirection northeast else 272 //label: @setDirNortheast\n" +
            "\tjump  304 //target: @done\n" +
            "\tturn left\n" +
            "\tdirection northeast else 272\n" +
            "\tjump  304 //target: @done\n" +
            "\tdirection east else 277 //label: @setDirEast\n" +
            "\tjump  304 //target: @done\n" +
            "\tturn left\n" +
            "\tdirection east else 277\n" +
            "\tjump  304 //target: @done\n" +
            "\tdirection southeast else 282 //label: @setDirSoutheast\n" +
            "\tjump  304 //target: @done\n" +
            "\tturn left\n" +
            "\tdirection southeast else 282\n" +
            "\tjump  304 //target: @done\n" +
            "\tdirection southwest else 287 //label: @setDirSouthwest\n" +
            "\tjump  304 //target: @done\n" +
            "\tturn left\n" +
            "\tdirection southwest else 287\n" +
            "\tjump  304 //target: @done\n" +
            "\tdirection west else 292 //label: @setDirWest\n" +
            "\tjump  304 //target: @done\n" +
            "\tturn left\n" +
            "\tdirection west else 292\n" +
            "\tjump  304 //target: @done\n" +
            "\tflip 3 else 297 //label: @setDirRandom\n" +
            "\tjump  304 //target: @done\n" +
            "\tflip 2 else 300\n" +
            "\tturn left\n" +
            "\tjump  304 //target: @done\n" +
            "\tturn right\n" +
            "\tjump  304 //target: @done\n" +
            "\tset 1 //label: @setDirNoFoodLeft\n" +
            "\tjump  295 //target: @setDirRandom // EOM: #interpretMarkerHome\n" +
            "\tmove else 246  //target: @begin//target: @begin //label: @afterInterpret\n" +
            "\tsense here home else 309 //BOM: #checkFoodDropOnHome\n" +
            "\tdrop else 309\n" +
            "\tunset 0\n" +
            "\tjump 309   //target: @return//target: @return//target: @return // EOM: #checkFoodDropOnHome\n" +
            "\tsense here friendfood else return\n" +
            "\tjump  246  //target: @begin//target: @begin // EOM: #followMarkerToHome\n" +
            "\tsense here friendfood else 313             //target: @collectFood\n" +
            "\tjump  177                      //target: @bringHome\n" +
            "\tsense here marker 0 else 318  //target: @begin//target: @state1 //label: @setDirectionWithMarkerFollowToFood //BOM: #interpretMarkerFood //label: @begin //BOM: #followMarkerToFood //label: @collectFood\n" +
            "\tsense here marker 1 else 322 //target: @state2\n" +
            "\tsense here marker 2 else 317\n" +
            "\tjump  365 //target: @setDirNoFoodLeft\n" +
            "\tjump  353 //target: @setDirWest\n" +
            "\tsense here marker 1 else 325 //target: @state3 //label: @state1\n" +
            "\tsense here marker 2 else 321\n" +
            "\tjump  338 //target: @setDirEast\n" +
            "\tjump  333 //target: @setDirNortheast\n" +
            "\tsense here marker 2 else 324 //label: @state2\n" +
            "\tjump  348 //target: @setDirSouthwest\n" +
            "\tjump  343 //target: @setDirSoutheast\n" +
            "\tsense here marker 2 else 327 //label: @state3\n" +
            "\tjump  328 //target: @setDirNorthwest\n" +
            "\tjump  358 //target: @setDirRandom\n" +
            "\tdirection northwest else 330 //label: @setDirNorthwest\n" +
            "\tjump  368    //target: @return//target: @return//target: @return//target: @return\n" +
            "\tturn left\n" +
            "\tdirection northwest else 330\n" +
            "\tjump  367 //target: @done\n" +
            "\tdirection northeast else 335 //label: @setDirNortheast\n" +
            "\tjump  367 //target: @done\n" +
            "\tturn left\n" +
            "\tdirection northeast else 335\n" +
            "\tjump  367 //target: @done\n" +
            "\tdirection east else 340 //label: @setDirEast\n" +
            "\tjump  367 //target: @done\n" +
            "\tturn left\n" +
            "\tdirection east else 340\n" +
            "\tjump  367 //target: @done\n" +
            "\tdirection southeast else 345 //label: @setDirSoutheast\n" +
            "\tjump  367 //target: @done\n" +
            "\tturn left\n" +
            "\tdirection southeast else 345\n" +
            "\tjump  367 //target: @done\n" +
            "\tdirection southwest else 350 //label: @setDirSouthwest\n" +
            "\tjump  367 //target: @done\n" +
            "\tturn left\n" +
            "\tdirection southwest else 350\n" +
            "\tjump  367 //target: @done\n" +
            "\tdirection west else 355 //label: @setDirWest\n" +
            "\tjump  367 //target: @done\n" +
            "\tturn left\n" +
            "\tdirection west else 355\n" +
            "\tjump  367 //target: @done\n" +
            "\tflip 3 else 360 //label: @setDirRandom\n" +
            "\tjump  367 //target: @done\n" +
            "\tflip 2 else 363\n" +
            "\tturn left\n" +
            "\tjump  367 //target: @done\n" +
            "\tturn right\n" +
            "\tjump  367 //target: @done\n" +
            "\tset 1 //label: @setDirNoFoodLeft\n" +
            "\tjump  358 //target: @setDirRandom\n" +
            "\tjump  368    //target: @return//target: @return//target: @return//target: @return //label: @done // EOM: #interpretMarkerFood\n" +
            "\ttest 1 else 370 //target: @moreFood\n" +
            "\tjump  385   //target: @return//target: @return//target: @return\n" +
            "\tsense ahead antlion else 373 //label: @checkForAntLion //BOM: #safe_dirWithFoehome //label: @moreFood\n" +
            "\tturn left\n" +
            "\tjump  370 //target: @checkForAntLion\n" +
            "\tsense ahead foehome else 376 //label: @checkForFoehome\n" +
            "\tturn left\n" +
            "\tjump 370 //target: @checkForAntLion\n" +
            "\tsense left foe else 380 //label: @checkForEnemy\n" +
            "\tsense right foe else 380\n" +
            "\tturn left\n" +
            "\tjump  370 //target: @checkForAntLion\n" +
            "\tjump 381    //target: @return//target: @return//target: @return//target: @return // EOM: #safe_dirWithFoehome\n" +
            "\tmove else 313  //target: @begin//target: @begin\n" +
            "\tpickup else 383 //target: @pickupTest\n" +
            "\tsense here friendfood else 313  //target: @begin//target: @begin //label: @pickupTest\n" +
            "\tjump 385   //target: @return//target: @return//target: @return // EOM: #followMarkerToFood\n" +
            "\tjump  1                          //target: @begin\n" +
            "}\n";
        ProgramParser pp = new ProgramParser();
        Program program = pp.parseProgram(brain1, new Random(0), 'A');
        for(Instruction i : program.getInstructions()) {
            System.out.println(i.serialize());
        }
    }

    private String filterString(String code) {
        String filtered = code.replaceAll("\\/\\*.*?\\n.*?\\*\\/", "\n");
        return filtered.replaceAll("\\/\\*.*?\\*\\/", " ");
    }
}
