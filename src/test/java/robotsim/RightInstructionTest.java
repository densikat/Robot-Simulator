package robotsim;

import static org.junit.Assert.*;

import org.junit.Test;

import robotsim.Commands.CommandFactory;
import robotsim.Instructions.Instruction;
import robotsim.Instructions.InstructionFactory;

public class RightInstructionTest {

  @Test
  public void testValidateNoRobotOnBoard() {
    InstructionFactory instructionFactory = new InstructionFactory();
    CommandFactory commandFactory = new CommandFactory();
    TableTop table = new TableTop(4,4);
    Command cmd = commandFactory.getCommand("RIGHT");
    Robot robot = new Robot();
    Instruction instruction = instructionFactory.getInstruction(cmd);
    assertFalse(instruction.validateInstruction(cmd, robot, table));
  }
  
  @Test
  public void testValidateValidLeft() {
    InstructionFactory instructionFactory = new InstructionFactory();
    CommandFactory commandFactory = new CommandFactory();
    TableTop table = new TableTop(4,4);
    
    Robot robot = new Robot();
    
    Command placeCmd = commandFactory.getCommand("PLACE 0,0,NORTH");
    Instruction placeInstruction = instructionFactory.getInstruction(placeCmd);
    robot.executeInstruction(placeCmd, placeInstruction, table);
    
    // Test change in each direction
    for (int i = 0; i < 4; i++) {
      Command cmd = commandFactory.getCommand("RIGHT");
      Instruction instruction = instructionFactory.getInstruction(cmd);
      robot.executeInstruction(cmd, instruction, table);
      
      assertTrue(instruction.validateInstruction(cmd, robot, table));
    }
    
  }

}
