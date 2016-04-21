package robotsim;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlaceInstructionTest {

  @Test
  public void testValidateBadPlaceInstruction() {
    InstructionFactory instructionFactory = new InstructionFactory();
    TableTop table = new TableTop(4,4);
    Command cmd = new Command("PLACE 5,6,NORTH");
    Robot robot = new Robot();
    Instruction instruction = instructionFactory.getInstruction(cmd);
    assertFalse(instruction.validateInstruction(cmd, robot, table));
  }
  
  @Test
  public void testValidateBadNegativePlaceInstruction() {
    InstructionFactory instructionFactory = new InstructionFactory();
    TableTop table = new TableTop(4,4);
    Command cmd = new Command("PLACE -1,-2,NORTH");
    Robot robot = new Robot();
    Instruction instruction = instructionFactory.getInstruction(cmd);
    assertFalse(instruction.validateInstruction(cmd, robot, table));
  }
  
  @Test
  public void testExecutePlaceTest() {
    InstructionFactory instructionFactory = new InstructionFactory();
    TableTop table = new TableTop(4,4);
    Command cmd = new Command("PLACE 0,0,NORTH");
    Robot robot = new Robot();
    Instruction instruction = instructionFactory.getInstruction(cmd);
    robot.executeInstruction(cmd, instruction, table);
    assertEquals(table.getCurrentRobot(),robot);
  }

}
