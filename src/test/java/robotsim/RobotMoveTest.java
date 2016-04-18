package robotsim;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * The Class RobotMoveTest.
 */
public class RobotMoveTest {

  /**
   * Test validate north bad move.
   */
  @Test
  public void testValidateNorthBadMove() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo();
    Command moveCommand = new Command("MOVE");
    Boolean commandReturn = robot.validateCommand(moveCommand, table);
    assertFalse(commandReturn);
  }

  /**
   * Test validate south bad move.
   */
  @Test
  public void testValidateSouthBadMove() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo();
    Command moveCommand = new Command("MOVE");
    Boolean commandReturn = robot.validateCommand(moveCommand, table);
    assertFalse(commandReturn);
  }

  /**
   * Test validate west bad move.
   */
  @Test
  public void testValidateWestBadMove() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo();
    Command moveCommand = new Command("MOVE");
    Boolean commandReturn = robot.validateCommand(moveCommand, table);
    assertFalse(commandReturn);
  }

  /**
   * Test validate east bad move.
   */
  @Test
  public void testValidateEastBadMove() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo();
    Command placeCommand = new Command("PLACE 4,3,EAST");
    Command moveCommand = new Command("MOVE");
    robot.executeCommand(placeCommand, table);
    Boolean commandReturn = robot.validateCommand(moveCommand, table);
    assertFalse(commandReturn);
  }

  /**
   * Test validate north good move.
   */
  @Test
  public void testValidateNorthGoodMove() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo();
    Command placeCommand = new Command("PLACE 0,0,EAST");
    Command moveCommand = new Command("MOVE");
    robot.executeCommand(placeCommand, table);
    Boolean commandReturn = robot.validateCommand(moveCommand, table);
    assertTrue(commandReturn);
  }

  /**
   * Test validate south good move.
   */
  @Test
  public void testValidateSouthGoodMove() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo();
    Command placeCommand = new Command("PLACE 3,2,SOUTH");
    Command moveCommand = new Command("MOVE");
    robot.executeCommand(placeCommand, table);
    Boolean commandReturn = robot.validateCommand(moveCommand, table);
    assertTrue(commandReturn);
  }

  /**
   * Test validate west good move.
   */
  @Test
  public void testValidateWestGoodMove() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo();
    Command placeCommand = new Command("PLACE 3,2,WEST");
    Command moveCommand = new Command("MOVE");
    robot.executeCommand(placeCommand, table);
    Boolean commandReturn = robot.validateCommand(moveCommand, table);
    assertTrue(commandReturn);
  }

  /**
   * Test validate east good move.
   */
  @Test
  public void testValidateEastGoodMove() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo();
    Command placeCommand = new Command("PLACE 2,4,EAST");
    Command moveCommand = new Command("MOVE");
    robot.executeCommand(placeCommand, table);
    Boolean commandReturn = robot.validateCommand(moveCommand, table);
    assertTrue(commandReturn);
  }
  
  /**
   * Test validate executed moves.
   */
  @Test
  public void testValidateExecutedMoves() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo();
    Command placeCommand = new Command("PLACE 2,4,EAST");
    Command moveCommand = new Command("MOVE");
    
    robot.executeCommand(placeCommand, table);
    robot.executeCommand(moveCommand, table);
    assertEquals(robot.getCurrentX(),3);
    
    table = new TableTop(4,4); // reset table
    placeCommand = new Command("PLACE 2,4,SOUTH");
    robot = new RobotDemo(); // reset robot to face south
    robot.executeCommand(placeCommand, table);
    robot.executeCommand(moveCommand, table); // move one spot
    assertEquals(robot.getCurrentY(),3);
  }

}
