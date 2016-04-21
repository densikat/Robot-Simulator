package robotsim;

import java.util.Hashtable;

public class Direction {
  private Hashtable<Integer, String> directionTable;
  
  public Direction() {
    directionTable = new Hashtable<Integer, String>();
    directionTable.put(1, "NORTH");
    directionTable.put(2, "EAST");
    directionTable.put(3, "SOUTH");
    directionTable.put(4, "WEST");
  }
  
  public String getDirection(Integer i) {
    return directionTable.get(i);
  }
  
  public Integer getNewXLocation(RobotDemo robot) {
    // Facing EAST, incremement current X, else
    // facing WEST, decrement current X
    if (robot.getDirection() == 2) {
      return robot.getCurrentX() + robot.moveLength;
    } else {
      return robot.getCurrentX() - robot.moveLength;
    }
  }
  
  public Integer getNewYLocation(RobotDemo robot) {
    // Facing NORTH, incremement current Y, else
    // facing SOUTH, decrement current X
    if (robot.getDirection() == 1) {
      return robot.getCurrentY() + robot.moveLength;
    } else {
      return robot.getCurrentY() - robot.moveLength;
    }
  }
}
