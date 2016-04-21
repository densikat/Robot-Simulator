package robotsim;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoveInstructionTest {

  @Test
  public void testValidateNoRobotOnBoard() {
    InstructionFactory instructionFactory = new InstructionFactory();
    TableTop table = new TableTop(4,4);
    Command cmd = new Command("MOVE");
    Robot robot = new Robot();
    Instruction instruction = instructionFactory.getInstruction(cmd);
    assertFalse(instruction.validateInstruction(cmd, robot, table));
  }
  
  @Test
  public void testValidateMoveOffXAxis() {
    InstructionFactory instructionFactory = new InstructionFactory();
    TableTop table = new TableTop(4,4);
    Command cmd = new Command("PLACE 4,0,EAST");
    Robot robot = new Robot();
    Instruction instruction = instructionFactory.getInstruction(cmd);
    robot.executeInstruction(cmd, instruction, table);
    
    Command moveCmd = new Command("MOVE");
    instruction = instructionFactory.getInstruction(moveCmd);
    
    assertFalse(instruction.validateInstruction(moveCmd, robot, table));
  }
  
  @Test
  public void testValidateMoveOffYAxis() {
    InstructionFactory instructionFactory = new InstructionFactory();
    TableTop table = new TableTop(4,4);
    Command cmd = new Command("PLACE 0,4,NORTH");
    Robot robot = new Robot();
    Instruction instruction = instructionFactory.getInstruction(cmd);
    robot.executeInstruction(cmd, instruction, table);
    
    Command moveCmd = new Command("MOVE");
    instruction = instructionFactory.getInstruction(moveCmd);
    
    assertFalse(instruction.validateInstruction(moveCmd, robot, table));
  }
  
  @Test
  public void testValidMove() {
    InstructionFactory instructionFactory = new InstructionFactory();
    TableTop table = new TableTop(4,4);
    Command cmd = new Command("PLACE 0,0,NORTH");
    Robot robot = new Robot();
    Instruction instruction = instructionFactory.getInstruction(cmd);
    robot.executeInstruction(cmd, instruction, table);
    
    Command moveCmd = new Command("MOVE");
    instruction = instructionFactory.getInstruction(moveCmd);
    robot.executeInstruction(moveCmd, instruction, table);
    
    assertEquals(robot.getCurrentX(),0);
  }
  
}
