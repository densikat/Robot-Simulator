package robotsim;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotDemoTests {

	@Test
	public void testValidateNorthBadMove() {
		RobotDemo robot = new RobotDemo(4,4,RobotDemo.direction.NORTH);
		Boolean commandReturn = robot.validateCommand("MOVE", 4, 4);
		assertFalse(commandReturn);
	}
	
	 @Test
	  public void testValidateNorthGoodMove() {
	    RobotDemo robot = new RobotDemo(0,0,RobotDemo.direction.NORTH);
	    Boolean commandReturn = robot.validateCommand("MOVE", 4, 4);
	    assertTrue(commandReturn);
	  }


}
