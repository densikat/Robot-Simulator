package robotsim;

public class LeftInstruction implements Instruction {

  @Override
  public Boolean validateInstruction(Command command, RobotDemo robot, TableTop table) {
    if (table.getCurrentRobot() == robot) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void executeInstruction(Command command, RobotDemo robot, TableTop table) {
    
    Integer newDirection;
    
    // Circle back around to West (4) if we are at North (1)
    if (robot.getDirection() == 1) {
      newDirection = 4;
    } else {
      newDirection = robot.getDirection() - 1;
    }

    robot.setDirection(newDirection);

  }

}
