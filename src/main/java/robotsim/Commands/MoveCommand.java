package robotsim.Commands;

import robotsim.Command;

/**
 * The Class MoveCommand.
 */
public class MoveCommand implements CommandInterface {

  /* (non-Javadoc)
   * @see robotsim.Commands.CommandInterface#getCommand(java.lang.String)
   */
  @Override
  public Command getCommand(String cmdString) {
    Command command = new Command();
    command.setCommandText("MOVE");
    return command;
  }
  
}
