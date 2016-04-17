package robotsim;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommandParseTest {

  @Test
  public void testAttemptParseCorrectMove() {
    Command cmd = new Command("MOVE");
    assertEquals (cmd.getCommandText(),"MOVE");
  }
  
  @Test
  public void testAttemptParseCorrectLeft() {
    Command cmd = new Command("LEFT");
    assertEquals (cmd.getCommandText(),"LEFT");
  }
  
  @Test
  public void testAttemptParseCorrectRight() {
    Command cmd = new Command("RIGHT");
    assertEquals (cmd.getCommandText(),"RIGHT");
  }
  
  @Test
  public void testAttemptParseCorrectReport() {
    Command cmd = new Command("REPORT");
    assertEquals (cmd.getCommandText(),"REPORT");
  }
  
  @Test
  public void testAttemptParseInvalidString() {
    Command cmd = new Command("MOVEE");
    assertEquals (cmd.getCommandText(),"INVALID");
  }
  
  @Test
  public void testAttemptParsePlaceValid() {
    Command cmd = new Command("PLACE 1,1,SOUTH");
    assertEquals (cmd.getCommandText(),"PLACE");
    assertEquals (cmd.getXcoordinate(),1);
    assertEquals (cmd.getYcoordinate(),1);
    assertEquals (cmd.getDirection(), Simulator.direction.SOUTH);
  }
  
  @Test
  public void testAttemptParsePlaceInvalidDataTypes() {
    Command cmd = new Command("PLACE Bad,1,SOUTH");
    assertEquals (cmd.getCommandText(),"INVALID");
  }
  
  @Test
  public void testAttemptParsePlaceInvalidCharacter() {
    Command cmd = new Command("PLACE $,1,SOUTH");
    assertEquals (cmd.getCommandText(),"INVALID");
  }

}
