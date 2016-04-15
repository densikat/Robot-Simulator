package robotsim;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotMoveTest {

  @Test
  public void testValidateNorthBadMove() {
    RobotDemo robot = new RobotDemo(4, 4, RobotDemo.direction.NORTH);
    Boolean commandReturn = robot.validateCommand("MOVE", 4, 4);
    assertFalse(commandReturn);
  }

  @Test
  public void testValidateSouthBadMove() {
    RobotDemo robot = new RobotDemo(4, 0, RobotDemo.direction.SOUTH);
    Boolean commandReturn = robot.validateCommand("MOVE", 4, 4);
    assertFalse(commandReturn);
  }

  @Test
  public void testValidateWestBadMove() {
    RobotDemo robot = new RobotDemo(0, 2, RobotDemo.direction.WEST);
    Boolean commandReturn = robot.validateCommand("MOVE", 4, 4);
    assertFalse(commandReturn);
  }

  @Test
  public void testValidateEastBadMove() {
    RobotDemo robot = new RobotDemo(4, 3, RobotDemo.direction.EAST);
    Boolean commandReturn = robot.validateCommand("MOVE", 4, 4);
    assertFalse(commandReturn);
  }

  @Test
  public void testValidateNorthGoodMove() {
    RobotDemo robot = new RobotDemo(0, 0, RobotDemo.direction.NORTH);
    Boolean commandReturn = robot.validateCommand("MOVE", 4, 4);
    assertTrue(commandReturn);
  }

  @Test
  public void testValidateSouthGoodMove() {
    RobotDemo robot = new RobotDemo(3, 2, RobotDemo.direction.SOUTH);
    Boolean commandReturn = robot.validateCommand("MOVE", 4, 4);
    assertTrue(commandReturn);
  }

  @Test
  public void testValidateWestGoodMove() {
    RobotDemo robot = new RobotDemo(3, 2, RobotDemo.direction.WEST);
    Boolean commandReturn = robot.validateCommand("MOVE", 4, 4);
    assertTrue(commandReturn);
  }

  @Test
  public void testValidateEastGoodMove() {
    RobotDemo robot = new RobotDemo(2, 4, RobotDemo.direction.EAST);
    Boolean commandReturn = robot.validateCommand("MOVE", 4, 4);
    assertTrue(commandReturn);
  }

}
