package robotsim.Commands;

import robotsim.Direction;
import robotsim.Robot;
import robotsim.TableTop;

/**
 * Command to report robots current position on table
 */
public class ReportCommand extends Command {

  /* (non-Javadoc)
   * @see robotsim.Commands.Command#initializeCommand(java.lang.String)
   */
  @Override
  public void initializeCommand(String cmdString) {
    this.setCommandText("REPORT");
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
    Direction dir = new Direction();
    
    String toWrite = String.format("%s,%s,%s", Integer.toString(robot.getCurrentWidth()),
        Integer.toString(robot.getCurrentHeight()), dir.getDirection(robot.getDirection()));
    System.out.println(toWrite);
  }

}
