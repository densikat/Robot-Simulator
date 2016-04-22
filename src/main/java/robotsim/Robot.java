package robotsim;

/**
 * Class representation of a Robot.
 */
public class Robot {

  /** The current x. */
  private int currentWidth;
  
  /** The current y. */
  private int currentHeight;
  
  /** The direction. */
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
  public int getCurrentWidth() {
    return currentWidth;
  }
  
  /**
   * Sets the current x.
   *
   * @param width the new current x
   */
  public void setCurrentWidth(int width) {
    currentWidth = width;
  }

  /**
   * Gets the current y.
   *
   * @return the current y
   */
  public int getCurrentHeight() {
    return currentHeight;
  }
  
  /**
   * Sets the current y.
   *
   * @param height the new current y
   */
  public void setCurrentHeight(int height) {
    currentHeight = height;
  }
  
  /**
   * Gets the direction.
   *
   * @return the direction
   */
  public Integer getDirection() {
    return direction;
  }
  
  /**
   * Sets the direction.
   *
   * @param dir the new direction
   */
  public void setDirection(Integer dir) {
    direction = dir;
  }
  
  /**
   * Gets the new x location.
   *
   * @return the new x location
   */
  public Integer getNewHorizontalLocation() {
    // Facing EAST, incremement current X, else
    // facing WEST, decrement current X
    if (this.getDirection() == 2) {
      return this.getCurrentWidth() + this.moveLength;
    } else {
      return this.getCurrentWidth() - this.moveLength;
    }
  }
  
  /**
   * Gets the new y location.
   *
   * @return the new y location
   */
  public Integer getNewVerticalLocation() {
    // Facing NORTH, incremement current Y, else
    // facing SOUTH, decrement current X
    if (this.getDirection() == 1) {
      return this.getCurrentHeight() + this.moveLength;
    } else {
      return this.getCurrentHeight() - this.moveLength;
    }
  }
  
  /**
   * Execute instruction.
   *
   * @param command the command to execute
   * @param instruction the instruction to execute
   * @param table the table to execute the instruction on
   */
  public void executeInstruction(Command command, Instruction instruction, TableTop table) {
    if (instruction.validateInstruction(command, this, table)) {
      instruction.executeInstruction(command, this, table);
    }
  }

}
