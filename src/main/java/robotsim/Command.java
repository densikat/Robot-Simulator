package robotsim;

/**
 * Command class.
 */
public class Command {
  
  /** The command text. */
  private String commandText;
  
  /** The x coordinate. */
  private int xCoordinate;
  
  /** The y coordinate. */
  private int yCoordinate;
  
  /** The direction. */
  private Simulator.direction direction;
  
  /**
   * Takes a string based command
   * Sends that command to attemptParse function
   * if command is valid then instance will be populated with 
   * relevant values.
   * 
   * If not the instance will be tagged as INVALID for later handling
   *
   * @param cmdText the command text input from file or user
   */
  public Command(String cmdText) {
    
    if (!attemptParse(cmdText)) {
      commandText = "INVALID";
    }
    
  }
  
  /**
   * Instantiates a new command.
   *
   * @param cmdText the cmd text
   * @param x the x
   * @param y the y
   * @param dir the direction in the command
   */
  public Command(String cmdText, int x, int y, Simulator.direction dir) {
    commandText = cmdText;
    xCoordinate = x;
    yCoordinate = y;
    direction = dir;
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
    return xCoordinate;
  }
  
  /**
   * Gets the ycoordinate.
   *
   * @return the ycoordinate
   */
  public int getYcoordinate() {
    return yCoordinate;
  }
  
  /**
   * Gets the direction.
   *
   * @return the direction
   */
  public Simulator.direction getDirection() {
    return direction;
  }
  
  /**
   * Validates string based command based populates instance if valid and
   * return true. Otherwise false is returned.
   *
   * @param command string based command
   * @return true if command was valid, false otherwise
   */
  public Boolean attemptParse(String command) {
    Boolean parseState = false;
    
    // Split string on space
    String[] splitCommand = command.split(" ");

    // if only one command, then check for left, right, move, report
    if (splitCommand.length == 1) {
      switch (splitCommand[0].toUpperCase()) {
        case "MOVE":
          parseState = true;
          commandText = "MOVE";
          break;
        case "LEFT":
          parseState = true;
          commandText = "LEFT";
          break;
        case "RIGHT":
          parseState = true;
          commandText = "RIGHT";
          break;
        case "REPORT":
          parseState = true;
          commandText = "REPORT";
          break;
        default:
          break;
      }
    } else if (splitCommand.length == 2) {
      if (splitCommand[0].toUpperCase().equals("PLACE")) {
        if (parsePlaceArguments(splitCommand[1])) {
          parseState = true;
        }
      }
    }
    
    return parseState;
  }
  
  /**
   * Parses the place command arguments.
   * Checks first two numbers are integers and that last argument
   * is a valid direction.
   *
   * @param args arguments for place command
   * @return true if command was valid, false otherwise
   */
  private Boolean parsePlaceArguments(String args) {
    Boolean parseState = false;
    
    String[] splitArgs = args.split(",");
    
    if (splitArgs.length == 3) {
      try {
        commandText = "PLACE";
        xCoordinate = Integer.parseInt(splitArgs[0]);
        yCoordinate = Integer.parseInt(splitArgs[1]);
        
        switch (splitArgs[2].toString().toUpperCase()) {
          case "NORTH":
            parseState = true;
            direction = Simulator.direction.NORTH;
            break;
          case "SOUTH":
            parseState = true;
            direction = Simulator.direction.SOUTH;
            break;
          case "WEST":
            parseState = true;
            direction = Simulator.direction.WEST;
            break;
          case "EAST":
            parseState = true;
            direction = Simulator.direction.EAST;
            break;
          default:
            break;
        }
        
      } catch (Exception ex) {
        parseState = false;
      }
    }
    
    return parseState;
  }
  
}
