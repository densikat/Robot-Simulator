package robotsim;

public class TableTop {
  private int xConstraint;
  private int yConstraint;
  private IRobot currentRobot;
  
  public TableTop (int x, int y) {
    xConstraint = x;
    yConstraint = y;
  }
  
  public int getXConstraint() {
    return xConstraint;
  }
  
  public int getYConstraint() {
    return yConstraint;
  }
  
  public IRobot getCurrentRobot() {
    return currentRobot;
  }
  
  public void setCurrentRobot(IRobot robot) {
    currentRobot = robot;
  }
  
}
