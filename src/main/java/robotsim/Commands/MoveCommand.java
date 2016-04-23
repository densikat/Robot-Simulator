package robotsim.Commands;

import robotsim.Robot;
import robotsim.TableTop;

/**
 * Command to move robot forward in the direction its facing
 */
public class MoveCommand extends Command {

  /* (non-Javadoc)
   * @see robotsim.Commands.Command#initializeCommand(java.lang.String)
   */
  @Override
  public void initializeCommand(String cmdString) {
    this.setCommandText("MOVE");

  }

  /* (non-Javadoc)
   * @see robotsim.Commands.Command#validateInstruction(robotsim.Robot, robotsim.TableTop)
   */
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

  /* (non-Javadoc)
   * @see robotsim.Commands.Command#executeInstruction(robotsim.Robot, robotsim.TableTop)
   */
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
