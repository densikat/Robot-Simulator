package robotsim;

/**
 * Instruction place robot on the table.
 */
public class PlaceInstruction implements Instruction {

  /* (non-Javadoc)
   * @see robotsim.Instruction#validateInstruction(robotsim.Command, robotsim.Robot, robotsim.TableTop)
   */
  @Override
  public Boolean validateInstruction(Command command, Robot robot, TableTop table) {
    Boolean returnVal = false;

    if (!(command.getCommandText().equals("INVALID"))) {
      // Validate position
      if (command.getXcoordinate() <= table.getTableWidth() && command.getXcoordinate() >= 0) {
        if (command.getYcoordinate() <= table.getTableHeight() && command.getYcoordinate() >= 0) {

          // Validate no robots on table
          if (table.getCurrentRobot() == null) {
            returnVal = true;
          }
        }
      }
    }
    return returnVal;
  }

  /* (non-Javadoc)
   * @see robotsim.Instruction#executeInstruction(robotsim.Command, robotsim.Robot, robotsim.TableTop)
   */
  @Override
  public void executeInstruction(Command command, Robot robot, TableTop table) {
    robot.setCurrentWidth(command.getXcoordinate());
    robot.setCurrentHeight(command.getYcoordinate());
    robot.setDirection(command.getDirection());
    table.setCurrentRobot(robot);
  }

}
