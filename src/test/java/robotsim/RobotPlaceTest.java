package robotsim;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * The Class RobotPlaceTest.
 */
public class RobotPlaceTest {

  /**
   * Test validate place with two robots.
   */
  @Test
  public void testValidatePlaceWithTwoRobots() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(4, 4, Simulator.direction.NORTH);
    RobotDemo robot2 = new RobotDemo(4, 4, Simulator.direction.NORTH);
    Command placeCommand = new Command("PLACE",0,0,1);
    Boolean commandReturn = robot.validateCommand(placeCommand, table);
    robot.executeCommand(placeCommand, table); // place robot on tabletop
    Command placeCommand2 = new Command("PLACE",0,0,1);
    
    // should fail as there is already a robot there
    Boolean commandReturn2 = robot2.validateCommand(placeCommand, table); 
    assertFalse(commandReturn2);
  }
  
  /**
   * Test validate place with x less than zero.
   */
  @Test
  public void testValidatePlaceWithXlessThanZero() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(-1, 4, Simulator.direction.NORTH);
    Command placeCommand = new Command("PLACE",-1,4,1);
    Boolean commandReturn = robot.validateCommand(placeCommand, table);
    assertFalse(commandReturn);
  }
  
  /**
   * Test validate place with x greater than zero.
   */
  @Test
  public void testValidatePlaceWithXgreaterThanZero() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(5, 4, Simulator.direction.NORTH);
    Command placeCommand = new Command("PLACE",5,4,1);
    Boolean commandReturn = robot.validateCommand(placeCommand, table);
    assertFalse(commandReturn);
  }
  
  /**
   * Test validate place with y less than zero.
   */
  @Test
  public void testValidatePlaceWithYlessThanZero() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(0, -1, Simulator.direction.NORTH);
    Command placeCommand = new Command("PLACE",0,-1,1);
    Boolean commandReturn = robot.validateCommand(placeCommand, table);
    assertFalse(commandReturn);
  }
  
  /**
   * Test validate place with y greater than4.
   */
  @Test
  public void testValidatePlaceWithYgreaterThan4() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(0, 5, Simulator.direction.NORTH);
    Command placeCommand = new Command("PLACE",0,5,1);
    Boolean commandReturn = robot.validateCommand(placeCommand, table);
    assertFalse(commandReturn);
  }
  
  /**
   * Test validate place with valid position.
   */
  @Test
  public void testValidatePlaceWithValidPosition() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo();
    Command placeCommand = new Command("PLACE",0,0,1);
    robot.executeCommand(placeCommand, table);
    assertEquals(table.getCurrentRobot(),robot);
  }
  
  /**
   * Test validate place with valid position2.
   */
  @Test
  public void testValidatePlaceWithValidPosition2() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo();
    Command placeCommand = new Command("PLACE",0,0,1);
    robot.executeCommand(placeCommand, table);
    assertEquals(table.getCurrentRobot(),robot);
  }
  
  /**
   * Test validate place validate x.
   */
  @Test
  public void testValidatePlaceValidateX() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo();
    Command placeCommand = new Command("PLACE",2,2,1);
    robot.executeCommand(placeCommand, table);
    assertEquals(table.getCurrentRobot(),robot);
    robot.executeCommand(placeCommand, table); // place robot on tabletop
    assertEquals(2,robot.getCurrentX());
  }
  
  /**
   * Test validate place validate y.
   */
  @Test
  public void testValidatePlaceValidateY() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo();
    Command placeCommand = new Command("PLACE",2,2,1);
    robot.executeCommand(placeCommand, table);
    assertEquals(table.getCurrentRobot(),robot);
    robot.executeCommand(placeCommand, table); // place robot on tabletop
    assertEquals(2,robot.getCurrentY());
  }

}
