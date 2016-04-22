package robotsim;

import java.util.Hashtable;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Direction.
 */
public class Direction {
  
  /** The direction table. */
  private Hashtable<Integer, String> directionTable;
  
  /**
   * Instantiates a new direction.
   */
  public Direction() {
    directionTable = new Hashtable<Integer, String>();
    directionTable.put(1, "NORTH");
    directionTable.put(2, "EAST");
    directionTable.put(3, "SOUTH");
    directionTable.put(4, "WEST");
  }
  
  /**
   * Validate direction.
   *
   * @param direction the direction
   * @return the boolean
   */
  public Boolean validateDirection (String direction) {
    int returnInt = 0;
    for (Map.Entry<Integer, String> entry: directionTable.entrySet()){
      if (direction.toUpperCase().equals(entry.getValue())) {
        returnInt = entry.getKey();
      }
    }
    
    if (returnInt == 0) {
      return false;
    } else {
      return true;
    }
    
  }
  
  /**
   * Gets the direction.
   *
   * @param directionIndex the index for direction hashtable
   * @return the direction
   */
  public String getDirection(int directionIndex) {
    return directionTable.get(directionIndex);
  }
  
  /**
   * Gets the direction index.
   *
   * @param direction the direction
   * @return the direction index
   */
  public int getDirectionIndex(String direction) {
    int returnInt = 0;
    for (Map.Entry<Integer, String> entry: directionTable.entrySet()){
      if (direction.toUpperCase().equals(entry.getValue())) {
        returnInt = entry.getKey();
      }
    }
    return returnInt;
  }
  
}
