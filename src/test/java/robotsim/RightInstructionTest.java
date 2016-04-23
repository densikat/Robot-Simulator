package robotsim;

import static org.junit.Assert.*;

import org.junit.Test;
import robotsim.Commands.Command;
import robotsim.Commands.CommandFactory;

public class RightInstructionTest {

  @Test
  public void testValidateNoRobotOnBoard() {
    CommandFactory commandFactory = new CommandFactory();
    TableTop table = new TableTop(4,4);
    Command cmd = commandFactory.getCommand("RIGHT");
    Robot robot = new Robot();
    assertFalse(cmd.validateInstruction(robot, table));
  }
  
  @Test
  public void testValidateValidLeft() {
    CommandFactory commandFactory = new CommandFactory();
    TableTop table = new TableTop(4,4);
    
    Robot robot = new Robot();
    
    Command placeCmd = commandFactory.getCommand("PLACE 0,0,NORTH");
    robot.executeInstruction(placeCmd, table);
    
    // Test change in each direction
    for (int i = 0; i < 4; i++) {
      Command cmd = commandFactory.getCommand("RIGHT");
      robot.executeInstruction(cmd, table);
      
      assertTrue(cmd.validateInstruction(robot, table));
    }
    
  }

}
