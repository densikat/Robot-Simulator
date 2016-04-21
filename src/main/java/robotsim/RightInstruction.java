package robotsim;

public class RightInstruction implements Instruction {

  @Override
  public Boolean validateInstruction(Command command, Robot robot, TableTop table) {
    if (table.getCurrentRobot() == robot) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void executeInstruction(Command command, Robot robot, TableTop table) {
    
    Integer newDirection;
    
    // Circle around to North (1) if we are at West (4)
    if (robot.getDirection() == 4) {
      newDirection = 1;
    } else {
      newDirection = robot.getDirection() + 1;
    }

    robot.setDirection(newDirection);
  }

}
