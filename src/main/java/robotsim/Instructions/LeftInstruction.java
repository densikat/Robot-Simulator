package robotsim.Instructions;

import robotsim.Command;
import robotsim.Robot;
import robotsim.TableTop;

// TODO: Auto-generated Javadoc
/**
 * Instruction to rotate robot left on table.
 */
public class LeftInstruction implements Instruction {

  /* (non-Javadoc)
   * @see robotsim.Instruction#validateInstruction(robotsim.Command, robotsim.Robot, robotsim.TableTop)
   */
  @Override
  public Boolean validateInstruction(Command command, Robot robot, TableTop table) {
    if (table.getCurrentRobot() == robot) {
      return true;
    } else {
      return false;
    }
  }

  /* (non-Javadoc)
   * @see robotsim.Instruction#executeInstruction(robotsim.Command, robotsim.Robot, robotsim.TableTop)
   */
  @Override
  public void executeInstruction(Command command, Robot robot, TableTop table) {
    
    Integer newDirection;
    
    // Circle back around to West (4) if we are at North (1)
    if (robot.getDirection() == 1) {
      newDirection = 4;
    } else {
      newDirection = robot.getDirection() - 1;
    }

    robot.setDirection(newDirection);

  }

}
