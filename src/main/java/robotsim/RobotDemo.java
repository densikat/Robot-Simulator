package robotsim;

public class RobotDemo implements IRobot {

  private int currentX;
  private int currentY;

  public enum direction {
    NORTH, SOUTH, EAST, WEST
  };

  private direction currentDirection;
  private static final int moveLength = 1; // How far the robot is allowed to move

  public RobotDemo(int xcoord, int ycoord, direction dir) {
    currentX = xcoord;
    currentY = ycoord;
    currentDirection = dir;
  }

  public Boolean validateCommand(String command, int xConstraint, int yConstraint) {

    Boolean returnVal = false;

    switch (command) {
    case "MOVE":
      returnVal = validateMove(xConstraint, yConstraint);
      break;
    default:
    }
    return returnVal;
  }

  private Boolean validateMove(int xConstraint, int yConstraint) {

    Boolean returnVal = false;

    switch (currentDirection) {
    case NORTH:
      if ((currentY + moveLength) <= yConstraint) {
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
      if ((currentX + moveLength) <= xConstraint) {
        returnVal = true;
      }
      break;
    default:
      break;
    }

    return returnVal;
  }

  public void executeCommand(String command) {
    // TODO Auto-generated method stub

  }

}
