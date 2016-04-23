package robotsim;

import static org.junit.Assert.*;

import org.junit.Test;
import robotsim.Commands.Command;
import robotsim.Commands.CommandFactory;

public class MoveInstructionTest {

  @Test
  public void testValidateNoRobotOnBoard() {
    CommandFactory commandFactory = new CommandFactory();
    TableTop table = new TableTop(4,4);
    Command cmd = commandFactory.getCommand("MOVE");
    Robot robot = new Robot();
    assertFalse(cmd.validateInstruction(robot, table));
  }
  
  @Test
  public void testValidateMoveOffXAxis() {
    CommandFactory commandFactory = new CommandFactory();
    TableTop table = new TableTop(4,4);
    Command cmd = commandFactory.getCommand("PLACE 4,0,EAST");
    Robot robot = new Robot();
    robot.executeInstruction(cmd, table);
    
    Command moveCmd = commandFactory.getCommand("MOVE");
    
    assertFalse(moveCmd.validateInstruction(robot, table));
  }
  
  @Test
  public void testValidateMoveOffYAxis() {
    CommandFactory commandFactory = new CommandFactory();
    TableTop table = new TableTop(4,4);
    Command cmd = commandFactory.getCommand("PLACE 0,4,NORTH");
    Robot robot = new Robot();
    robot.executeInstruction(cmd, table);
    
    Command moveCmd = commandFactory.getCommand("MOVE");
    
    assertFalse(moveCmd.validateInstruction(robot, table));
  }
  
  @Test
  public void testValidMove() {
    CommandFactory commandFactory = new CommandFactory();
    TableTop table = new TableTop(4,4);
    Command cmd = commandFactory.getCommand("PLACE 0,0,NORTH");
    Robot robot = new Robot();
    robot.executeInstruction(cmd, table);
    
    Command moveCmd = commandFactory.getCommand("MOVE");
    robot.executeInstruction(moveCmd, table);
    
    assertEquals(robot.getCurrentWidth(),0);
  }
  
}
