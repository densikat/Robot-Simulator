package robotsim;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotPlaceTest {

  @Test
  public void testValidatePlaceWithTwoRobots() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(4, 4, Simulator.direction.NORTH);
    RobotDemo robot2 = new RobotDemo(4, 4, Simulator.direction.NORTH);
    Command placeCommand = new Command("PLACE",0,0,Simulator.direction.NORTH);
    Boolean commandReturn = robot.validateCommand(placeCommand, table);
    robot.executeCommand(placeCommand, table); // place robot on tabletop
    Command placeCommand2 = new Command("PLACE",0,0,Simulator.direction.NORTH);
    Boolean commandReturn2 = robot2.validateCommand(placeCommand, table); // should fail as there is already a robot there
    assertFalse(commandReturn2);
  }
  
  @Test
  public void testValidatePlaceWithXlessThanZero() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(-1, 4, Simulator.direction.NORTH);
    Command placeCommand = new Command("PLACE",-1,4,Simulator.direction.NORTH);
    Boolean commandReturn = robot.validateCommand(placeCommand, table);
    assertFalse(commandReturn);
  }
  
  @Test
  public void testValidatePlaceWithXgreaterThanZero() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(5, 4, Simulator.direction.NORTH);
    Command placeCommand = new Command("PLACE",5,4,Simulator.direction.NORTH);
    Boolean commandReturn = robot.validateCommand(placeCommand, table);
    assertFalse(commandReturn);
  }
  
  @Test
  public void testValidatePlaceWithYlessThanZero() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(0, -1, Simulator.direction.NORTH);
    Command placeCommand = new Command("PLACE",0,-1,Simulator.direction.NORTH);
    Boolean commandReturn = robot.validateCommand(placeCommand, table);
    assertFalse(commandReturn);
  }
  
  @Test
  public void testValidatePlaceWithYgreaterThan4() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(0, 5, Simulator.direction.NORTH);
    Command placeCommand = new Command("PLACE",0,5,Simulator.direction.NORTH);
    Boolean commandReturn = robot.validateCommand(placeCommand, table);
    assertFalse(commandReturn);
  }
  
  @Test
  public void testValidatePlaceWithValidPosition() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(0, 0, Simulator.direction.NORTH);
    Command placeCommand = new Command("PLACE",0,0,Simulator.direction.NORTH);
    Boolean commandReturn = robot.validateCommand(placeCommand, table);
    assertTrue(commandReturn);
  }
  
  @Test
  public void testValidatePlaceWithValidPosition2() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(4, 4, Simulator.direction.NORTH);
    Command placeCommand = new Command("PLACE",0,0,Simulator.direction.NORTH);
    Boolean commandReturn = robot.validateCommand(placeCommand, table);
    assertTrue(commandReturn);
  }
  
  @Test
  public void testValidatePlaceValidateX() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(4, 4, Simulator.direction.NORTH);
    Command placeCommand = new Command("PLACE",2,2,Simulator.direction.NORTH);
    Boolean commandReturn = robot.validateCommand(placeCommand, table);
    assertTrue(commandReturn);
    robot.executeCommand(placeCommand, table); // place robot on tabletop
    assertEquals(2,robot.getCurrentX());
  }
  
  @Test
  public void testValidatePlaceValidateY() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(4, 4, Simulator.direction.NORTH);
    Command placeCommand = new Command("PLACE",2,2,Simulator.direction.NORTH);
    Boolean commandReturn = robot.validateCommand(placeCommand, table);
    assertTrue(commandReturn);
    robot.executeCommand(placeCommand, table); // place robot on tabletop
    assertEquals(2,robot.getCurrentY());
  }

}
