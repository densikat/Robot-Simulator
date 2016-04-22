package robotsim.Commands;

import robotsim.Robot;
import robotsim.TableTop;

public class RobotRightCommand extends RobotCommand {

  @Override
  public void initializeCommand(String cmdString) {
    this.setCommandText("RIGHT");
  }

  @Override
  public Boolean validateInstruction(Robot robot, TableTop table) {
    if (table.getCurrentRobot() == robot) {
      return true;
    } else {
      return false;
    }
  }

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
