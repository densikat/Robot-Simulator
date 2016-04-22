package robotsim;

import static org.junit.Assert.*;

import org.junit.Test;

import robotsim.Commands.RobotCommand;
import robotsim.Commands.RobotCommandFactory;

public class CommandClassTest {

  @Test()
  public void testValidateBadDataTypePlaceInstruction() {
    RobotCommandFactory commandFactory = new RobotCommandFactory();
    RobotCommand cmd = commandFactory.getCommand("PLACE 0,A,NORTH");
    assertEquals(cmd, null);
  }
  
  @Test()
  public void testValidateBadDataTypePlaceInstruction2() {
    RobotCommandFactory commandFactory = new RobotCommandFactory();
    RobotCommand cmd = commandFactory.getCommand("PLACE 0,1,1");
    assertEquals(cmd, null);
  }

}
