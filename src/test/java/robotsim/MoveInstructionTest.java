package robotsim;

import static org.junit.Assert.*;

import org.junit.Test;
import robotsim.Commands.RobotCommand;
import robotsim.Commands.RobotCommandFactory;

public class MoveInstructionTest {

  @Test
  public void testValidateNoRobotOnBoard() {
    RobotCommandFactory commandFactory = new RobotCommandFactory();
    TableTop table = new TableTop(4,4);
    RobotCommand cmd = commandFactory.getCommand("MOVE");
    Robot robot = new Robot();
    assertFalse(cmd.validateInstruction(robot, table));
  }
  
  @Test
  public void testValidateMoveOffXAxis() {
    RobotCommandFactory commandFactory = new RobotCommandFactory();
    TableTop table = new TableTop(4,4);
    RobotCommand cmd = commandFactory.getCommand("PLACE 4,0,EAST");
    Robot robot = new Robot();
    robot.executeInstruction(cmd, table);
    
    RobotCommand moveCmd = commandFactory.getCommand("MOVE");
    
    assertFalse(moveCmd.validateInstruction(robot, table));
  }
  
  @Test
  public void testValidateMoveOffYAxis() {
    RobotCommandFactory commandFactory = new RobotCommandFactory();
    TableTop table = new TableTop(4,4);
    RobotCommand cmd = commandFactory.getCommand("PLACE 0,4,NORTH");
    Robot robot = new Robot();
    robot.executeInstruction(cmd, table);
    
    RobotCommand moveCmd = commandFactory.getCommand("MOVE");
    
    assertFalse(moveCmd.validateInstruction(robot, table));
  }
  
  @Test
  public void testValidMove() {
    RobotCommandFactory commandFactory = new RobotCommandFactory();
    TableTop table = new TableTop(4,4);
    RobotCommand cmd = commandFactory.getCommand("PLACE 0,0,NORTH");
    Robot robot = new Robot();
    robot.executeInstruction(cmd, table);
    
    RobotCommand moveCmd = commandFactory.getCommand("MOVE");
    robot.executeInstruction(moveCmd, table);
    
    assertEquals(robot.getCurrentWidth(),0);
  }
  
}
