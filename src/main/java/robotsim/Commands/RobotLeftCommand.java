package robotsim.Commands;

import robotsim.Robot;
import robotsim.TableTop;

public class RobotLeftCommand extends RobotCommand {

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
    
    // Circle back around to West (4) if we are at North (1)
    if (robot.getDirection() == 1) {
      newDirection = 4;
    } else {
      newDirection = robot.getDirection() - 1;
    }

    robot.setDirection(newDirection);
    
  }

  @Override
  public void initializeCommand(String cmdString) {
    this.setCommandText(cmdString);
    
  }

}
