package robotsim;

import java.util.Hashtable;

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
   * Gets the direction.
   *
   * @param directionIndex the index for direction hashtable
   * @return the direction
   */
  public String getDirection(int directionIndex) {
    return directionTable.get(directionIndex);
  }
  
}
