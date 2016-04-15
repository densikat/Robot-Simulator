package robotsim;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotRightTest {

  @Test
  public void testRightNoRobotPlacedOnBoard() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(0, 0, Simulator.direction.EAST);
    Command rightCommand = new Command("RIGHT");
    Boolean commandReturn = robot.validateCommand(rightCommand, table);
    assertFalse(commandReturn);
  }
  
  @Test
  public void testRightRobotPlacedOnBoard() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(0, 0, Simulator.direction.EAST);
    Command placeCommand = new Command("PLACE",0,0,Simulator.direction.NORTH);
    robot.executeCommand(placeCommand, table); // place robot on tabletop
    Command rightCommand = new Command("RIGHT");
    Boolean commandReturn = robot.validateCommand(rightCommand, table); // validate the command to turn left
    assertTrue(commandReturn);
  }
  
  @Test
  public void testRightRobotExecution() {
    TableTop table = new TableTop(4,4);
    RobotDemo robot = new RobotDemo(0, 0, Simulator.direction.NORTH);
    Command placeCommand = new Command("PLACE",0,0,Simulator.direction.NORTH);
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
