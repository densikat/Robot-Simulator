package robotsim;

public class RobotDemo implements IRobot {

  private int currentX;
  private int currentY;
  private Simulator.direction currentDirection;
  private static final int moveLength = 1; // How far the robot is allowed to move

  public RobotDemo(int xcoord, int ycoord, Simulator.direction dir) {
    currentX = xcoord;
    currentY = ycoord;
    currentDirection = dir;
  }

  public Boolean validateCommand(Command command, TableTop table) {

    Boolean returnVal = false;

    switch (command.getCommandText()) {
      case "MOVE":
        returnVal = validateMove(table);
        break;
      default:
        break;
    }
    return returnVal;
  }

  private Boolean validateMove(TableTop table) {

    Boolean returnVal = false;

    switch (currentDirection) {
      case NORTH:
        if ((currentY + moveLength) <= table.getYConstraint()) {
          returnVal = true;
        }
        break;
      case SOUTH:
        if ((currentY - moveLength) >= 0) {
          returnVal = true;
        }
        break;
      case WEST:
        if ((currentX - moveLength) >= 0) {
          returnVal = true;
        }
        break;
      case EAST:
        if ((currentX + moveLength) <= table.getXConstraint()) {
          returnVal = true;
        }
        break;
      default:
        break;
    }

    return returnVal;
    
  }

  public void executeCommand(Command command) {
    // TODO Auto-generated method stub

  }

}
