package robotsim;

import robotsim.Commands.Command;

/**
 * Class representation of a Robot.
 */
public class Robot {

  /** The current x location of the robot on the table. */
  private int currentWidth;
  
  /** The current y location of the robot on the table. */
  private int currentHeight;
  
  /** The direction. */
  private int direction;
  
  /** The Constant moveLength. */
  public final int moveLength = 1; // How far the robot is allowed to move

  /**
   * Instantiates a new default instance of robot.
   */
  public Robot() {}

  /**
   * Gets the current x location of the robot.
   *
   * @return the current x
   */
  public int getCurrentWidth() {
    return currentWidth;
  }
  
  /**
   * Sets the current x location of the robot.
   *
   * @param width the new current x
   */
  public void setCurrentWidth(int width) {
    currentWidth = width;
  }

  /**
   * Gets the current y location of the robot.
   *
   * @return the current y
   */
  public int getCurrentHeight() {
    return currentHeight;
  }
  
  /**
   * Sets the current y location of the robot.
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
  public int getDirection() {
    return direction;
  }
  
  /**
   * Sets the direction.
   *
   * @param dir the new direction
   */
  public void setDirection(int dir) {
    direction = dir;
  }
  
  /**
   * Gets the new x location.
   *
   * @return the new x location
   */
  public int getNewHorizontalLocation() {
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
  public int getNewVerticalLocation() {
    // Facing NORTH, incremement current Y, else
    // facing SOUTH, decrement current X
    if (this.getDirection() == 1) {
      return this.getCurrentHeight() + this.moveLength;
    } else {
      return this.getCurrentHeight() - this.moveLength;
    }
  }
  
  /**
   * Validate and execute the given instruction.
   *
   * @param command the command to execute
   * @param table the table to execute the instruction on
   */
  public void executeInstruction(Command command, TableTop table) {
    
    if (command.validateInstruction(this, table)) {
      command.executeInstruction(this, table);
    }
    
  }

}
