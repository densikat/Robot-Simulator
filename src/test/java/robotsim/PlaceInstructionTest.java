package robotsim;

import static org.junit.Assert.*;

import org.junit.Test;
import robotsim.Commands.Command;
import robotsim.Commands.CommandFactory;

public class PlaceInstructionTest {

  @Test
  public void testValidateBadPlaceInstruction() {
    CommandFactory commandFactory = new CommandFactory();
    TableTop table = new TableTop(4,4);
    Command cmd = commandFactory.getCommand("PLACE 5,6,NORTH");
    Robot robot = new Robot();
    assertFalse(cmd.validateInstruction(robot, table));
  }
  
  @Test
  public void testValidateBadNegativePlaceInstruction() {
    CommandFactory commandFactory = new CommandFactory();
    TableTop table = new TableTop(4,4);
    Command cmd = commandFactory.getCommand("PLACE -1,-2,NORTH");
    Robot robot = new Robot();
    assertFalse(cmd.validateInstruction(robot, table));
  }
  
  @Test
  public void testExecutePlaceTest() {
    CommandFactory commandFactory = new CommandFactory();
    TableTop table = new TableTop(4,4);
    Command cmd = commandFactory.getCommand("PLACE 0,0,NORTH");
    Robot robot = new Robot();
    robot.executeInstruction(cmd, table);
    assertEquals(table.getCurrentRobot(),robot);
  }

}
