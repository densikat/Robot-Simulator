package robotsim.Commands;

import robotsim.Command;
import robotsim.Direction;

/**
 * The Class PlaceCommand.
 */
public class PlaceCommand implements CommandInterface {
  
  /**
   * Instantiates a new place command.
   */
  public PlaceCommand() {};

  /* (non-Javadoc)
   * @see robotsim.Commands.CommandInterface#getCommand(java.lang.String)
   */
  @Override
  public Command getCommand(String cmdString) {
    
    Boolean validCommand = true;
    String[] args = cmdString.split(" ");

    // We should only have two arguments place and the arguments
    // invalid command if not 2
    if (args.length != 2) {
      validCommand = false;
    }
    
    // if arguments dont match digit, digit, word (4, 5 range)
    // throw exception
    if (args[1].matches("-?\\d{1},-?\\d{1},\\w{4,5}") == false) {
      validCommand = false;
    }
    
    String[] splitArgs = args[1].split(",");
    Command command = new Command();
    Direction direction = new Direction();
    
    // If input direction is not valid throw exception
    if (!direction.validateDirection(splitArgs[2])) {
      validCommand = false;
    }
    
    if (validCommand) {
      
      command.setCommandWidth(Integer.parseInt(splitArgs[0]));
      command.setCommandHeight(Integer.parseInt(splitArgs[1]));
      command.setCommandText("PLACE");
      command.setDirection(direction.getDirectionIndex(splitArgs[2]));
      
      return command;
    } else {
      return null;
    }
    
  }

}
