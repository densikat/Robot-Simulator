package robotsim.Commands;

import robotsim.Robot;
import robotsim.TableTop;

/**
 * Command to rotate robot to the right
 */
public class RightCommand extends Command {

  /* (non-Javadoc)
   * @see robotsim.Commands.Command#initializeCommand(java.lang.String)
   */
  @Override
  public void initializeCommand(String cmdString) {
    this.setCommandText("RIGHT");
  }

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
    
    // Circle around to North (1) if we are at West (4)
    if (robot.getDirection() == 4) {
      newDirection = 1;
    } else {
      newDirection = robot.getDirection() + 1;
    }

    robot.setDirection(newDirection);
  }

}
