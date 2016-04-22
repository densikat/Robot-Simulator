package robotsim;

import static org.junit.Assert.*;

import org.junit.Test;

import robotsim.Commands.CommandFactory;
import robotsim.Instructions.Instruction;
import robotsim.Instructions.InstructionFactory;

public class MoveInstructionTest {

  @Test
  public void testValidateNoRobotOnBoard() {
    InstructionFactory instructionFactory = new InstructionFactory();
    CommandFactory commandFactory = new CommandFactory();
    TableTop table = new TableTop(4,4);
    Command cmd = commandFactory.getCommand("MOVE");
    Robot robot = new Robot();
    Instruction instruction = instructionFactory.getInstruction(cmd);
    assertFalse(instruction.validateInstruction(cmd, robot, table));
  }
  
  @Test
  public void testValidateMoveOffXAxis() {
    InstructionFactory instructionFactory = new InstructionFactory();
    CommandFactory commandFactory = new CommandFactory();
    TableTop table = new TableTop(4,4);
    Command cmd = commandFactory.getCommand("PLACE 4,0,EAST");
    Robot robot = new Robot();
    Instruction instruction = instructionFactory.getInstruction(cmd);
    robot.executeInstruction(cmd, instruction, table);
    
    Command moveCmd = commandFactory.getCommand("MOVE");
    instruction = instructionFactory.getInstruction(moveCmd);
    
    assertFalse(instruction.validateInstruction(moveCmd, robot, table));
  }
  
  @Test
  public void testValidateMoveOffYAxis() {
    InstructionFactory instructionFactory = new InstructionFactory();
    CommandFactory commandFactory = new CommandFactory();
    TableTop table = new TableTop(4,4);
    Command cmd = commandFactory.getCommand("PLACE 0,4,NORTH");
    Robot robot = new Robot();
    Instruction instruction = instructionFactory.getInstruction(cmd);
    robot.executeInstruction(cmd, instruction, table);
    
    Command moveCmd = commandFactory.getCommand("MOVE");
    instruction = instructionFactory.getInstruction(moveCmd);
    
    assertFalse(instruction.validateInstruction(moveCmd, robot, table));
  }
  
  @Test
  public void testValidMove() {
    InstructionFactory instructionFactory = new InstructionFactory();
    CommandFactory commandFactory = new CommandFactory();
    TableTop table = new TableTop(4,4);
    Command cmd = commandFactory.getCommand("PLACE 0,0,NORTH");
    Robot robot = new Robot();
    Instruction instruction = instructionFactory.getInstruction(cmd);
    robot.executeInstruction(cmd, instruction, table);
    
    Command moveCmd = commandFactory.getCommand("MOVE");
    instruction = instructionFactory.getInstruction(moveCmd);
    robot.executeInstruction(moveCmd, instruction, table);
    
    assertEquals(robot.getCurrentWidth(),0);
  }
  
}
