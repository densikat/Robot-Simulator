package robotsim;

/**
 * Class representation of table top.
 */
public class TableTop {
  
  /** The width of the TableTop. */
  private int tableWidth;
  
  /** The height of the TableTop. */
  private int tableHeight;
  
  /** The current robot. */
  private Robot currentRobot;

  /**
   * Instantiates a new table top.
   *
   * @param width the width of the table
   * @param height the height of the table
   */
  public TableTop(int width, int height) {
    tableWidth = width;
    tableHeight = height;
  }

  /**
   * Gets the width of the table.
   *
   * @return the width
   */
  public int getTableWidth() {
    return tableWidth;
  }

  /**
   * Gets the height of the table
   *
   * @return the height of the table
   */
  public int getTableHeight() {
    return tableHeight;
  }

  /**
   * Gets the current robot on the table.
   *
   * @return the current robot
   */
  public Robot getCurrentRobot() {
    return currentRobot;
  }

  /**
   * Sets the current robot on the table.
   *
   * @param robot the new current robot
   */
  public void setCurrentRobot(Robot robot) {
    currentRobot = robot;
  }

}
