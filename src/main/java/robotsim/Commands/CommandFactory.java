package robotsim.Commands;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import robotsim.Command;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Command objects.
 */
public class CommandFactory {

  private Hashtable<String, String> commandList;
  
  public CommandFactory() {
    commandList = new Hashtable<String, String>();
    
    commandList.put("MOVE", "robotsim.Commands.MoveCommand");
    commandList.put("LEFT", "robotsim.Commands.LeftCommand");
    commandList.put("RIGHT", "robotsim.Commands.RightCommand");
    commandList.put("REPORT", "robotsim.Commands.ReportCommand");
    commandList.put("PLACE", "robotsim.Commands.PlaceCommand");
  }
  
  private String getClassName(String cmdString) {
    String classString = "";
    if (commandList.containsKey(cmdString)) {
      classString = commandList.get(cmdString);
    }
    
    return classString;
  }
  /**
   * Gets the command.
   *
   * @param cmdCommand string representation of command
   * @return the command
   */
  
  public Command getCommand(String cmdCommand) {
    
    CommandInterface command = null;
    
    // Split string on space
    String[] splitCommand = cmdCommand.split(" ");
    
    String className = getClassName(splitCommand[0].toUpperCase());
    
    if (!(className.equals(""))) {
      try {
        command = (CommandInterface) Class.forName(className).newInstance();
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
    if (command != null) {
      return command.getCommand(cmdCommand);  
    } else {
      return null;
    }
    
    
  }
  
}
