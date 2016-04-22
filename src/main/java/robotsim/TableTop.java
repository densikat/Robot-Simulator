package robotsim;

// TODO: Auto-generated Javadoc
/**
 * Class representation of table top.
 */
public class TableTop {
  
  /** The X constraint of the TableTop. */
  private int tableWidth;
  
  /** The Y constraint of the TableTop. */
  private int tableHeight;
  
  /** The current robot. */
  private Robot currentRobot;

  /**
   * Instantiates a new table top.
   *
   * @param width the x constraint of the table
   * @param height the y constraint of the table
   */
  public TableTop(int width, int height) {
    tableWidth = width;
    tableHeight = height;
  }

  /**
   * Gets the x constraint.
   *
   * @return the x constraint
   */
  public int getTableWidth() {
    return tableWidth;
  }

  /**
   * Gets the y constraint.
   *
   * @return the y constraint
   */
  public int getTableHeight() {
    return tableHeight;
  }

  /**
   * Gets the current robot.
   *
   * @return the current robot
   */
  public Robot getCurrentRobot() {
    return currentRobot;
  }

  /**
   * Sets the current robot.
   *
   * @param robot the new current robot
   */
  public void setCurrentRobot(Robot robot) {
    currentRobot = robot;
  }

}
