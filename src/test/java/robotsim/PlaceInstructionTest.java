package robotsim;

import static org.junit.Assert.*;

import org.junit.Test;
import robotsim.Commands.RobotCommand;
import robotsim.Commands.RobotCommandFactory;

public class PlaceInstructionTest {

  @Test
  public void testValidateBadPlaceInstruction() {
    RobotCommandFactory commandFactory = new RobotCommandFactory();
    TableTop table = new TableTop(4,4);
    RobotCommand cmd = commandFactory.getCommand("PLACE 5,6,NORTH");
    Robot robot = new Robot();
    assertFalse(cmd.validateInstruction(robot, table));
  }
  
  @Test
  public void testValidateBadNegativePlaceInstruction() {
    RobotCommandFactory commandFactory = new RobotCommandFactory();
    TableTop table = new TableTop(4,4);
    RobotCommand cmd = commandFactory.getCommand("PLACE -1,-2,NORTH");
    Robot robot = new Robot();
    assertFalse(cmd.validateInstruction(robot, table));
  }
  
  @Test
  public void testExecutePlaceTest() {
    RobotCommandFactory commandFactory = new RobotCommandFactory();
    TableTop table = new TableTop(4,4);
    RobotCommand cmd = commandFactory.getCommand("PLACE 0,0,NORTH");
    Robot robot = new Robot();
    robot.executeInstruction(cmd, table);
    assertEquals(table.getCurrentRobot(),robot);
  }

}
