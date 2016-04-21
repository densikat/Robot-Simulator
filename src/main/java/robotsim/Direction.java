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
  
}
