package robotsim.Commands;

import robotsim.Robot;
import robotsim.TableTop;

public class RobotMoveCommand extends RobotCommand {

  @Override
  public void initializeCommand(String cmdString) {
    this.setCommandText("MOVE");

  }

  @Override
  public Boolean validateInstruction(Robot robot, TableTop table) {
    Boolean validMove = false;
    
    // If robot is facing NORTH or SOUTH then calculate if a MOVE instruction
    // would be within a valid Y range.
    // Else
    // If robot is facing EAST or WEST then calculate if a MOVE instruction
    // would be within a valid X range
    if (table.getCurrentRobot() == robot) {
      if (robot.getDirection() == 1 || robot.getDirection() == 3) {
        int newYLocation = robot.getNewVerticalLocation();
        if ((newYLocation >= 0) && (newYLocation <= table.getTableHeight())) {
          validMove = true;
        }
      } else {
        int newXLocation = robot.getNewHorizontalLocation();
        if ((newXLocation >= 0) && (newXLocation <= table.getTableWidth())) {
          validMove = true;
        }
      }
    }
    
 
    return validMove;
  }

  @Override
  public void executeInstruction(Robot robot, TableTop table) {
    switch (robot.getDirection()) {
    case 1: // North
      robot.setCurrentHeight(robot.getCurrentHeight() + robot.moveLength);
      break;
    case 2: // East
      robot.setCurrentWidth(robot.getCurrentWidth() + robot.moveLength);
      break;
    case 3: // South
      robot.setCurrentHeight(robot.getCurrentHeight() - robot.moveLength);
      break;
    case 4: // West
      robot.setCurrentWidth(robot.getCurrentWidth() - robot.moveLength);
      break;
    default:
      break;
  }

  }

}
