package robotsim;

public class Command {
  private String commandText;
  private int xCoordinate;
  private int yCoordinate;
  private Simulator.direction direction;
  
  public Command(String cmdText) {
    
    if(!attemptParse(cmdText)) {
      commandText = "INVALID";
    }
    
  }
  
  public Command(String cmdText, int x, int y, Simulator.direction dir) {
   commandText = cmdText;
   xCoordinate = x;
   yCoordinate = y;
   direction = dir;
  }
  
  public String getCommandText() {
    return commandText;
  }
  
  public int getXcoordinate() {
    return xCoordinate;
  }
  
  public int getYcoordinate() {
    return yCoordinate;
  }
  
  public Simulator.direction getDirection() {
    return direction;
  }
  
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
        
      } 
      catch (Exception ex) {
        parseState = false;
      }
    }
    
    return parseState;
  }
  
}
