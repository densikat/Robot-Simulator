package robotsim;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * The Class RobotRightTest.
 */
public class RobotRightTest {

  /**
   * Test right no robot placed on board.
   */
  @Test
  public void testRightNoRobotPlacedOnBoard() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(0, 0, Simulator.direction.EAST);
    Command rightCommand = new Command("RIGHT");
    Boolean commandReturn = robot.validateCommand(rightCommand, table);
    assertFalse(commandReturn);
  }
  
  /**
   * Test right robot placed on board.
   */
  @Test
  public void testRightRobotPlacedOnBoard() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(0, 0, Simulator.direction.EAST);
    Command placeCommand = new Command("PLACE",0,0,1);
    robot.executeCommand(placeCommand, table); // place robot on tabletop
    Command rightCommand = new Command("RIGHT");
    
    // validate the command to turn left
    Boolean commandReturn = robot.validateCommand(rightCommand, table); 
    assertTrue(commandReturn);
  }
  
  /**
   * Test right robot execution.
   */
  @Test
  public void testRightRobotExecution() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(0, 0, Simulator.direction.NORTH);
    Command placeCommand = new Command("PLACE",0,0,1);
    robot.executeCommand(placeCommand, table); // place robot on tabletop
    
    Command rightCommand = new Command("RIGHT");
    robot.executeCommand(rightCommand, table); // place robot on tabletop
    assertEquals(Simulator.direction.EAST, robot.getCurrentDirection());
    
    rightCommand = new Command("RIGHT");
    robot.executeCommand(rightCommand, table); // place robot on tabletop
    assertEquals(Simulator.direction.SOUTH, robot.getCurrentDirection());
    
    rightCommand = new Command("RIGHT");
    robot.executeCommand(rightCommand, table); // place robot on tabletop
    assertEquals(Simulator.direction.WEST, robot.getCurrentDirection());
    
    rightCommand = new Command("RIGHT");
    robot.executeCommand(rightCommand, table); // place robot on tabletop
    assertEquals(Simulator.direction.NORTH, robot.getCurrentDirection());
    
  }

}
