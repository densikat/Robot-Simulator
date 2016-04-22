package robotsim.Instructions;

import robotsim.Command;
import robotsim.Robot;
import robotsim.TableTop;

// TODO: Auto-generated Javadoc
/**
 * Move instruction, used to validate and move a robot around the board.
 */
public class MoveInstruction implements Instruction {

  /* (non-Javadoc)
   * @see robotsim.Instruction#validateInstruction(robotsim.Command, robotsim.Robot, robotsim.TableTop)
   */
  @Override
  public Boolean validateInstruction(Command command, Robot robot, TableTop table) {
    
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
   * @see robotsim.Instruction#executeInstruction(robotsim.Command, robotsim.Robot, robotsim.TableTop)
   */
  @Override
  public void executeInstruction(Command command, Robot robot, TableTop table) {
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
