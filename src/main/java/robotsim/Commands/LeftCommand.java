package robotsim.Commands;

import robotsim.Robot;
import robotsim.TableTop;

/**
 * Command to rotate robot to the left
 */
public class LeftCommand extends Command {

  /* (non-Javadoc)
   * @see robotsim.Commands.Command#validateInstruction(robotsim.Robot, robotsim.TableTop)
   */
  @Override
  public Boolean validateInstruction(Robot robot, TableTop table) {
    if (table.getCurrentRobot() == robot) {
      return true;
    } else {
      return false;
    }
  }

  /* (non-Javadoc)
   * @see robotsim.Commands.Command#executeInstruction(robotsim.Robot, robotsim.TableTop)
   */
  @Override
  public void executeInstruction(Robot robot, TableTop table) {
    int newDirection;
    
    // Circle back around to West (4) if we are at North (1)
    if (robot.getDirection() == 1) {
      newDirection = 4;
    } else {
      newDirection = robot.getDirection() - 1;
    }

    robot.setDirection(newDirection);
    
  }

  /* (non-Javadoc)
   * @see robotsim.Commands.Command#initializeCommand(java.lang.String)
   */
  @Override
  public void initializeCommand(String cmdString) {
    this.setCommandText(cmdString);
    
  }

}
