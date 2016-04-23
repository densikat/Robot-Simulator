package robotsim.Commands;

import java.util.Hashtable;

/**
 * A factory for creating Command objects.
 */
public class CommandFactory {
  
  /** The command list. */
  private Hashtable<String, String> commandList;
  
  /**
   * Instantiates a new command factory.
   */
  public CommandFactory() {
    commandList = new Hashtable<String, String>();
    
    commandList.put("MOVE", "robotsim.Commands.MoveCommand");
    commandList.put("LEFT", "robotsim.Commands.LeftCommand");
    commandList.put("RIGHT", "robotsim.Commands.RightCommand");
    commandList.put("REPORT", "robotsim.Commands.ReportCommand");
    commandList.put("PLACE", "robotsim.Commands.PlaceCommand");
    commandList.put("EXIT", "robotsim.Commands.ExitCommand");
  }
  
  /**
   * Gets the class name.
   *
   * @param cmdString the cmd string
   * @return the class name
   */
  private String getClassName(String cmdString) {
    String classString = "";
    if (commandList.containsKey(cmdString)) {
      classString = commandList.get(cmdString);
    }
    
    return classString;
  }
  
  /**
   * If the command is in our hashtable keys
   * then return the relevant instance of the object
   * based on the hashtable value. Object is dynamically
   * generated using reflection.
   * If not a valid command then return null object
   * caller needs to check for this.
   *
   * @param cmdCommand string representation of command
   * @return the command
   */
  
  public Command getCommand(String cmdCommand) {
    
    Command command = null;
    
    // Split string on space
    String[] splitCommand = cmdCommand.split(" ");
    
    String className = getClassName(splitCommand[0].toUpperCase());
    
    if (!(className.equals(""))) {
      try {
        command = (Command) Class.forName(className).newInstance();
        command.initializeCommand(cmdCommand);
      } catch (InstantiationException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
    }
    
    // If we have received a valid object then return the command object from it
    // otherwise we will return null and handle in calling code.
    if (command != null && command.getCommandText() != null) {
      return command;  
    } else {
      return null;
    }
    
    
  }

}
