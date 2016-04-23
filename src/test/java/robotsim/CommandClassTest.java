package robotsim;

import static org.junit.Assert.*;

import org.junit.Test;

import robotsim.Commands.Command;
import robotsim.Commands.CommandFactory;

public class CommandClassTest {

  @Test()
  public void testValidateBadDataTypePlaceInstruction() {
    CommandFactory commandFactory = new CommandFactory();
    Command cmd = commandFactory.getCommand("PLACE 0,A,NORTH");
    assertEquals(cmd, null);
  }
  
  @Test()
  public void testValidateBadDataTypePlaceInstruction2() {
    CommandFactory commandFactory = new CommandFactory();
    Command cmd = commandFactory.getCommand("PLACE 0,1,1");
    assertEquals(cmd, null);
  }

}
