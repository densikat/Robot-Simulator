package robotsim;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommandClassTest {

  @Test
  public void testValidateBadDataTypePlaceInstruction() {
    Command cmd = new Command("PLACE 0,A,NORTH");
    assertTrue(cmd.getCommandText().toUpperCase().equals("INVALID"));
  }

}
