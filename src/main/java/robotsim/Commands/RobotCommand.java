package robotsim.Commands;

import robotsim.Robot;
import robotsim.TableTop;

public abstract class RobotCommand {
  /** The command text. */
  private String commandText;
  
  /** The x coordinate. */
  private int commandWidth;
  
  /** The y coordinate. */
  private int commandHeight;
  
  /** The direction. */
  private Integer direction;
  
  /**
   * Sets the command text.
   *
   * @param cmdText the new command text
   */
  public void setCommandText (String cmdText) {
    commandText = cmdText;
  }
  
  /**
   * Gets the command text.
   *
   * @return the command text
   */
  public String getCommandText() {
    return commandText;
  }
  
  /**
   * Gets the xcoordinate.
   *
   * @return the xcoordinate
   */
  public int getXcoordinate() {
    return commandWidth;
  }
  
  /**
   * Gets the ycoordinate.
   *
   * @return the ycoordinate
   */
  public int getYcoordinate() {
    return commandHeight;
  }
  
  /**
   * Sets the command width.
   *
   * @param width the new command width
   */
  public void setCommandWidth(int width) {
    commandWidth = width;
  }
  
  /**
   * Sets the command height.
   *
   * @param height the new command height
   */
  public void setCommandHeight(int height) {
    commandHeight = height;
  }
  
  /**
   * Sets the direction.
   *
   * @param directionIndex the new direction
   */
  public void setDirection (int directionIndex) {
    direction = directionIndex;
  }
  
  /**
   * Gets the direction.
   *
   * @return the direction
   */
  public Integer getDirection() {
    return direction;
  }
  
  public abstract void initializeCommand(String cmdString);
  public abstract Boolean validateInstruction(Robot robot, TableTop table);
  public abstract void executeInstruction(Robot robot, TableTop table);
}
