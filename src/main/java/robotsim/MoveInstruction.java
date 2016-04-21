package robotsim;

public class MoveInstruction implements Instruction {

  @Override
  public Boolean validateInstruction(Command command, RobotDemo robot, TableTop table) {
    
    Direction direction = new Direction();
    Boolean validMove = false;
    
    // If robot is facing NORTH or SOUTH then calculate if a MOVE instruction
    // would be within a valid Y range.
    // Else
    // If robot is facing EAST or WEST then calculate if a MOVE instruction
    // would be within a valid X range
    if (table.getCurrentRobot() == robot) {
      if (robot.getDirection() == 1 || robot.getDirection() == 3) {
        int newYLocation = direction.getNewYLocation(robot);
        if ((newYLocation >= 0) && (newYLocation <= table.getYConstraint())) {
          validMove = true;
        }
      } else {
        int newXLocation = direction.getNewXLocation(robot);
        if ((newXLocation >= 0) && (newXLocation <= table.getXConstraint())) {
          validMove = true;
        }
      }
    }
    
 
    return validMove;
  }

  @Override
  public void executeInstruction(Command command, RobotDemo robot, TableTop table) {
    switch (robot.getDirection()) {
      case 1: // North
        robot.setCurrentY(robot.getCurrentY() + robot.moveLength);
        break;
      case 2: // East
        robot.setCurrentX(robot.getCurrentX() + robot.moveLength);
        break;
      case 3: // South
        robot.setCurrentY(robot.getCurrentY() - robot.moveLength);
        break;
      case 4: // West
        robot.setCurrentX(robot.getCurrentX() - robot.moveLength);
        break;
      default:
        break;
    }

  }

}
