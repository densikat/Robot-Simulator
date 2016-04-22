package robotsim.Instructions;

import robotsim.Command;
import robotsim.Direction;
import robotsim.Robot;
import robotsim.TableTop;

// TODO: Auto-generated Javadoc
/**
 * Instruction report current location and
 * coordinates of robot on table.
 */
public class ReportInstruction implements Instruction {

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
    Direction dir = new Direction();
    
    String toWrite = String.format("%s,%s,%s", Integer.toString(robot.getCurrentWidth()),
        Integer.toString(robot.getCurrentHeight()), dir.getDirection(robot.getDirection()));
    System.out.println(toWrite);

  }

}
