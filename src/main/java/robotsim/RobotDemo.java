package robotsim;

/**
 * The Class RobotDemo.
 */
public class RobotDemo {

  /** The current x. */
  private int currentX;
  
  /** The current y. */
  private int currentY;
  
  /** The current direction. */
  private Simulator.direction currentDirection;
  
  /** The Constant moveLength. */
  private static final int moveLength = 1; // How far the robot is allowed to move

  /**
   * Instantiates a new default instance of robot.
   */
  public RobotDemo() {}

  /**
   * Instantiates a new robot demo.
   *
   * @param xcoord xcoordinate of robot on tabletop
   * @param ycoord ycoordinate of robot on tabletop
   * @param dir the direction the robot is facing
   */
  public RobotDemo(int xcoord, int ycoord, Simulator.direction dir) {
    currentX = xcoord;
    currentY = ycoord;
    currentDirection = dir;
  }

  /**
   * Gets the current x.
   *
   * @return the current x
   */
  public int getCurrentX() {
    return currentX;
  }

  /**
   * Gets the current y.
   *
   * @return the current y
   */
  public int getCurrentY() {
    return currentY;
  }

  /**
   * Gets the current direction.
   *
   * @return the current direction the robot is facing
   */
  public Simulator.direction getCurrentDirection() {
    return currentDirection;
  }

  /**
   * Makes sure command is valid based on tabletop size
   * and robots position and directional heading.
   *
   * @param command instance of the command to validate
   * @param table instance of the TableTop in use
   * @return true if command is valid, false if invalid
   */
  public Boolean validateCommand(Command command, TableTop table) {

    Boolean returnVal = false;
    
    // Handle place here as we don't have a robot on the board at that time
    // so can't drop into null check below
    if (command.getCommandText().toUpperCase().equals("PLACE")) {
      returnVal = validatePlace(command, table);
    }

    if (!(table.getCurrentRobot() == null)) {
      switch (command.getCommandText()) {
        case "MOVE":
          returnVal = validateMove(table);
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
    }
    
    return returnVal;
  }

  /**
   * Validate robot placed.
   *
   * @param table instance of the TableTop in use
   * @return true if robot place command is valid, false otherwise
   */
  private Boolean validateRobotPlaced(TableTop table) {
    if (table.getCurrentRobot() == this) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Validate place command.
   *
   * @param command the place command to validate
   * @param table instance of the TableTop in use
   * @return true if place command is valid, false otherwise
   */
  private Boolean validatePlace(Command command, TableTop table) {
    Boolean returnVal = false;

    // Validate position
    if (command.getXcoordinate() <= table.getXConstraint() && command.getXcoordinate() >= 0) {
      if (command.getYcoordinate() <= table.getYConstraint() && command.getYcoordinate() >= 0) {

        // Validate no robots on table
        if (table.getCurrentRobot() == null) {
          returnVal = true;
        }
      }
    }
    return returnVal;
  }

  /**
   * Validate move.
   *
   * @param table instance of the TableTop in use
   * @return true if the move command is valid, false otherwise
   */
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

  /**
   * Execute place command.
   *
   * @param command the place command to execute
   * @param table instance of the TableTop in use
   */
  private void executePlace(Command command, TableTop table) {
    currentX = command.getXcoordinate();
    currentY = command.getYcoordinate();
    currentDirection = command.getDirection();
    table.setCurrentRobot(this);
  }

  /**
   * Execute left turn command.
   */
  private void executeLeft() {
    switch (currentDirection) {
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

  /**
   * Execute right turn command.
   */
  private void executeRight() {
    switch (currentDirection) {
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

  /**
   * Execute report command.
   */
  private void executeReport() {
    String toWrite = String.format("%s,%s,%s", Integer.toString(currentX),
        Integer.toString(currentY), currentDirection.toString());
    System.out.println(toWrite);
  }

  /**
   * Execute move command.
   */
  private void executeMove() {
    switch (currentDirection) {
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

  /**
   * Execute command.
   *
   * @param command instance of the command to execute
   * @param table instance of the TableTop in use
   */
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
