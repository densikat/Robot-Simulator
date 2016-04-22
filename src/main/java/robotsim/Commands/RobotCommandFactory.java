package robotsim.Commands;

import java.util.Hashtable;

public class RobotCommandFactory {
  
  private Hashtable<String, String> commandList;
  
  public RobotCommandFactory() {
    commandList = new Hashtable<String, String>();
    
    commandList.put("MOVE", "robotsim.Commands.RobotMoveCommand");
    commandList.put("LEFT", "robotsim.Commands.RobotLeftCommand");
    commandList.put("RIGHT", "robotsim.Commands.RobotRightCommand");
    commandList.put("REPORT", "robotsim.Commands.RobotReportCommand");
    commandList.put("PLACE", "robotsim.Commands.RobotPlaceCommand");
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
  
  public RobotCommand getCommand(String cmdCommand) {
    
    RobotCommand command = null;
    
    // Split string on space
    String[] splitCommand = cmdCommand.split(" ");
    
    String className = getClassName(splitCommand[0].toUpperCase());
    
    if (!(className.equals(""))) {
      try {
        command = (RobotCommand) Class.forName(className).newInstance();
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
