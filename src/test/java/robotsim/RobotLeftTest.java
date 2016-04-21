package robotsim;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * The Class RobotLeftTest.
 */
public class RobotLeftTest {

  /**
   * Test left no robot placed on board.
   */
  @Test
  public void testLeftNoRobotPlacedOnBoard() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(0, 0, Simulator.direction.EAST);
    Command leftCommand = new Command("LEFT");
    Boolean commandReturn = robot.validateCommand(leftCommand, table);
    assertFalse(commandReturn);
  }
  
  /**
   * Test left robot placed on board.
   */
  @Test
  public void testLeftRobotPlacedOnBoard() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo();
    Command placeCommand = new Command("PLACE",0,0,1);
    robot.executeCommand(placeCommand, table); // place robot on tabletop
    Command leftCommand = new Command("LEFT");
    
    // validate the command to turn left
    Boolean commandReturn = robot.validateCommand(leftCommand, table); 
    assertTrue(commandReturn);
  }
  
  /**
   * Test left robot execution.
   */
  @Test
  public void testLeftRobotExecution() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(0, 0, Simulator.direction.NORTH);
    Command placeCommand = new Command("PLACE",0,0,1);
    robot.executeCommand(placeCommand, table); // place robot on tabletop
    
    Command leftCommand = new Command("LEFT");
    robot.executeCommand(leftCommand, table); // place robot on tabletop
    assertEquals(Simulator.direction.WEST, robot.getCurrentDirection());
    
    leftCommand = new Command("LEFT");
    robot.executeCommand(leftCommand, table); // place robot on tabletop
    assertEquals(Simulator.direction.SOUTH, robot.getCurrentDirection());
    
    leftCommand = new Command("LEFT");
    robot.executeCommand(leftCommand, table); // place robot on tabletop
    assertEquals(Simulator.direction.EAST, robot.getCurrentDirection());
    
    leftCommand = new Command("LEFT");
    robot.executeCommand(leftCommand, table); // place robot on tabletop
    assertEquals(Simulator.direction.NORTH, robot.getCurrentDirection());
    
  }
  
}
