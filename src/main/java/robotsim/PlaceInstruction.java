package robotsim;

public class PlaceInstruction implements Instruction {

  @Override
  public Boolean validateInstruction(Command command, Robot robot, TableTop table) {
    Boolean returnVal = false;

    if (!(command.getCommandText().equals("INVALID"))) {
   // Validate position
      if (command.getXcoordinate() <= table.getXConstraint() && command.getXcoordinate() >= 0) {
        if (command.getYcoordinate() <= table.getYConstraint() && command.getYcoordinate() >= 0) {

          // Validate no robots on table
          if (table.getCurrentRobot() == null) {
            returnVal = true;
          }
        }
      }
    }
      return returnVal;
  }

  @Override
  public void executeInstruction(Command command, Robot robot, TableTop table) {
    robot.setCurrentX(command.getXcoordinate());
    robot.setCurrentY(command.getYcoordinate());
    robot.setDirection(command.getDirection());
    table.setCurrentRobot(robot);
  }

}
