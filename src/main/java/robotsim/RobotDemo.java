package robotsim;

public class RobotDemo implements IRobot {

  private int currentX;
  private int currentY;
  private Simulator.direction currentDirection;
  private static final int moveLength = 1; // How far the robot is allowed to move

  public RobotDemo(){};
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
  
  public Simulator.direction getCurrentDirection() {
    return currentDirection;
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
      case "LEFT":
        returnVal = validateRobotPlaced(table);
        break;
      case "RIGHT":
        returnVal = validateRobotPlaced(table);
        break;
      case "REPORT":
        returnVal = validateRobotPlaced(table); 
        break;
      default:
        break;
    }
    return returnVal;
  }
  
  private Boolean validateRobotPlaced(TableTop table) {
    if (table.getCurrentRobot() == this) {
      return true;
    } else {
      return false;
    }
  }
  
  private Boolean validatePlace(Command command, TableTop table) {
    Boolean returnVal = false;
    
    // Validate position
    if(command.getXcoordinate() <= table.getXConstraint() && command.getXcoordinate() >= 0) {
      if(command.getYcoordinate() <= table.getYConstraint() && command.getYcoordinate() >= 0) {
        
        // Validate no robots on table
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
  
  private void executePlace(Command command, TableTop table) {
    currentX = command.getXcoordinate();
    currentY = command.getYcoordinate();
    currentDirection = command.getDirection();
    table.setCurrentRobot(this);
  }
  
  private void executeLeft() {
    switch(currentDirection) {
    case NORTH:
      currentDirection = Simulator.direction.WEST;
      break;
    case SOUTH:
      currentDirection = Simulator.direction.EAST;
      break;
    case WEST:
      currentDirection = Simulator.direction.SOUTH;
      break;
    case EAST:
      currentDirection = Simulator.direction.NORTH;
      break;
    default:
      break;
    }
  }
  
  private void executeRight() {
    switch(currentDirection) {
    case NORTH:
      currentDirection = Simulator.direction.EAST;
      break;
    case SOUTH:
      currentDirection = Simulator.direction.WEST;
      break;
    case WEST:
      currentDirection = Simulator.direction.NORTH;
      break;
    case EAST:
      currentDirection = Simulator.direction.SOUTH;
      break;
    default:
      break;
    }
  }
  
  private void executeReport() {
    String toWrite = String.format("%s,%s,%s",Integer.toString(currentX),Integer.toString(currentY),currentDirection.toString());
    System.out.println(toWrite);
  }
  
  private void executeMove() {
    switch(currentDirection) {
    case NORTH:
      currentY += moveLength;
      break;
    case SOUTH:
      currentY -= moveLength;
      break;
    case WEST:
      currentX -= moveLength;
      break;
    case EAST:
      currentX += moveLength;
      break;
    default:
      break;
    }
  }

  public void executeCommand(Command command, TableTop table) {
    switch (command.getCommandText()) {
    case "PLACE":
      executePlace(command, table);
      break;
    case "LEFT":
      executeLeft();
      break;
    case "RIGHT":
      executeRight();
      break;
    case "REPORT":
      executeReport();
      break;
    case "MOVE":
      executeMove();
      break;
    default:
      break;
  }

  }

}
