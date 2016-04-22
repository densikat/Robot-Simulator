package robotsim.Commands;

import robotsim.Direction;
import robotsim.Robot;
import robotsim.TableTop;

public class RobotReportCommand extends RobotCommand {

  @Override
  public void initializeCommand(String cmdString) {
    this.setCommandText("REPORT");
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
    Direction dir = new Direction();
    
    String toWrite = String.format("%s,%s,%s", Integer.toString(robot.getCurrentWidth()),
        Integer.toString(robot.getCurrentHeight()), dir.getDirection(robot.getDirection()));
    System.out.println(toWrite);
  }

}
