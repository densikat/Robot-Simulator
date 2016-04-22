package robotsim;

import static org.junit.Assert.*;

import org.junit.Test;

import robotsim.Commands.RobotCommand;
import robotsim.Commands.RobotCommandFactory;

public class LeftInstructionTest {

  @Test
  public void testValidateNoRobotOnBoard() {
    RobotCommandFactory commandFactory = new RobotCommandFactory();
    TableTop table = new TableTop(4,4);
    RobotCommand cmd = commandFactory.getCommand("LEFT");
    Robot robot = new Robot();
    assertFalse(cmd.validateInstruction(robot, table));
  }
  
  @Test
  public void testValidateValidLeft() {
    RobotCommandFactory commandFactory = new RobotCommandFactory();
    TableTop table = new TableTop(4,4);
    
    Robot robot = new Robot();
    
    RobotCommand placeCmd = commandFactory.getCommand("PLACE 0,0,NORTH");
    robot.executeInstruction(placeCmd, table);
    
    // Test change in each direction
    for (int i = 0; i < 4; i++) {
      RobotCommand cmd = commandFactory.getCommand("LEFT");
      robot.executeInstruction(cmd, table);
      
      assertTrue(cmd.validateInstruction(robot, table));
    }
    
  }

}
