package robotsim.Commands;

import robotsim.Command;

// TODO: Auto-generated Javadoc
/**
 * The Class RightCommand.
 */
public class RightCommand implements CommandInterface {

  /* (non-Javadoc)
   * @see robotsim.Commands.CommandInterface#getCommand(java.lang.String)
   */
  @Override
  public Command getCommand(String cmdString) {
    Command command = new Command();
    command.setCommandText("RIGHT");
    return command;
  }

}
