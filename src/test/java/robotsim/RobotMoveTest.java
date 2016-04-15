package robotsim;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotMoveTest {

  @Test
  public void testValidateNorthBadMove() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(4, 4, Simulator.direction.NORTH);
    Command moveCommand = new Command("MOVE");
    Boolean commandReturn = robot.validateCommand(moveCommand, table);
    assertFalse(commandReturn);
  }

  @Test
  public void testValidateSouthBadMove() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(4, 0, Simulator.direction.SOUTH);
    Command moveCommand = new Command("MOVE");
    Boolean commandReturn = robot.validateCommand(moveCommand, table);
    assertFalse(commandReturn);
  }

  @Test
  public void testValidateWestBadMove() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(0, 2, Simulator.direction.WEST);
    Command moveCommand = new Command("MOVE");
    Boolean commandReturn = robot.validateCommand(moveCommand, table);
    assertFalse(commandReturn);
  }

  @Test
  public void testValidateEastBadMove() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(4, 3, Simulator.direction.EAST);
    Command moveCommand = new Command("MOVE");
    Boolean commandReturn = robot.validateCommand(moveCommand, table);
    assertFalse(commandReturn);
  }

  @Test
  public void testValidateNorthGoodMove() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(0, 0, Simulator.direction.NORTH);
    Command moveCommand = new Command("MOVE");
    Boolean commandReturn = robot.validateCommand(moveCommand, table);
    assertTrue(commandReturn);
  }

  @Test
  public void testValidateSouthGoodMove() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(3, 2, Simulator.direction.SOUTH);
    Command moveCommand = new Command("MOVE");
    Boolean commandReturn = robot.validateCommand(moveCommand, table);
    assertTrue(commandReturn);
  }

  @Test
  public void testValidateWestGoodMove() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(3, 2, Simulator.direction.WEST);
    Command moveCommand = new Command("MOVE");
    Boolean commandReturn = robot.validateCommand(moveCommand, table);
    assertTrue(commandReturn);
  }

  @Test
  public void testValidateEastGoodMove() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(2, 4, Simulator.direction.EAST);
    Command moveCommand = new Command("MOVE");
    Boolean commandReturn = robot.validateCommand(moveCommand, table);
    assertTrue(commandReturn);
  }
  
  @Test
  public void testValidateExecutedMoves() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(2, 4, Simulator.direction.EAST);
    Command moveCommand = new Command("MOVE");
    
    robot.executeCommand(moveCommand, table);
    assertEquals(robot.getCurrentX(),3);
    
    robot = new RobotDemo(2, 4, Simulator.direction.SOUTH); // reset robot to face south
    robot.executeCommand(moveCommand, table); // move one spot
    assertEquals(robot.getCurrentY(),3);
  }

}
