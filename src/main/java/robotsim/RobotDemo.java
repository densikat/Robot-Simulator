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
  
  public int getCurrentX() {
    return currentX;
  }
  
  public int getCurrentY() {
    return currentY;
  }
  
  public Boolean validateCommand(Command command, TableTop table) {

    Boolean returnVal = false;

    switch (command.getCommandText()) {
      case "MOVE":
        returnVal = validateMove(table);
        break;
      case "PLACE":
        returnVal = validatePlace(command, table);
        break;
      default:
        break;
    }
    return returnVal;
  }
  
  private Boolean validatePlace(Command command, TableTop table) {
    Boolean returnVal = false;
    
    // Validate position
    if(command.getXcoordinate() <= table.getXConstraint() && command.getXcoordinate() >= 0) {
      if(command.getYcoordinate() <= table.getYConstraint() && command.getYcoordinate() >= 0) {
        
        // Valid no robots on table
        if(table.getCurrentRobot() == null) {
          returnVal = true;
        }
      }
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

  public void executeCommand(Command command, TableTop table) {
    switch (command.getCommandText()) {
    case "PLACE":
      currentX = command.getXcoordinate();
      currentY = command.getYcoordinate();
      currentDirection = command.getDirection();
      table.setCurrentRobot(this);
      break;
    default:
      break;
  }

  }

}
