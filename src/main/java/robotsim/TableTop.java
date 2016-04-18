package robotsim;

/**
 * TableTop class.
 */
public class TableTop {
  
  /** The X constraint of the TableTop. */
  private int xConstraint;
  
  /** The Y constraint of the TableTop. */
  private int yConstraint;
  
  /** The current robot. */
  private RobotDemo currentRobot;

  /**
   * Instantiates a new table top.
   *
   * @param x the x constraint of the table
   * @param y the y constraint of the table
   */
  public TableTop(int x, int y) {
    xConstraint = x;
    yConstraint = y;
  }

  /**
   * Gets the x constraint.
   *
   * @return the x constraint
   */
  public int getXConstraint() {
    return xConstraint;
  }

  /**
   * Gets the y constraint.
   *
   * @return the y constraint
   */
  public int getYConstraint() {
    return yConstraint;
  }

  /**
   * Gets the current robot.
   *
   * @return the current robot
   */
  public RobotDemo getCurrentRobot() {
    return currentRobot;
  }

  /**
   * Sets the current robot.
   *
   * @param robot the new current robot
   */
  public void setCurrentRobot(RobotDemo robot) {
    currentRobot = robot;
  }

}
