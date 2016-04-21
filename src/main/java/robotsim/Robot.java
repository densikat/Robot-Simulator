package robotsim;

/**
 * The Class RobotDemo.
 */
public class Robot {

  /** The current x. */
  private int currentX;
  
  /** The current y. */
  private int currentY;
  
  private Integer direction;
  
  /** The Constant moveLength. */
  public final int moveLength = 1; // How far the robot is allowed to move

  /**
   * Instantiates a new default instance of robot.
   */
  public Robot() {}

  /**
   * Gets the current x.
   *
   * @return the current x
   */
  public int getCurrentX() {
    return currentX;
  }
  
  public void setCurrentX(Integer x) {
    currentX = x;
  }

  /**
   * Gets the current y.
   *
   * @return the current y
   */
  public int getCurrentY() {
    return currentY;
  }
  
  public void setCurrentY(Integer y) {
    currentY = y;
  }
  
  public Integer getDirection() {
    return direction;
  }
  
  public void setDirection(Integer dir) {
    direction = dir;
  }
  
  public Integer getNewXLocation() {
    // Facing EAST, incremement current X, else
    // facing WEST, decrement current X
    if (this.getDirection() == 2) {
      return this.getCurrentX() + this.moveLength;
    } else {
      return this.getCurrentX() - this.moveLength;
    }
  }
  
  public Integer getNewYLocation() {
    // Facing NORTH, incremement current Y, else
    // facing SOUTH, decrement current X
    if (this.getDirection() == 1) {
      return this.getCurrentY() + this.moveLength;
    } else {
      return this.getCurrentY() - this.moveLength;
    }
  }
  
  public void executeInstruction(Command command, Instruction instruction, TableTop table) {
    if (instruction.validateInstruction(command, this, table)) {
      instruction.executeInstruction(command, this, table);
    }
  }

}
