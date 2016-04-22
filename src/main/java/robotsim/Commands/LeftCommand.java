package robotsim.Commands;

import robotsim.Command;

// TODO: Auto-generated Javadoc
/**
 * The Class LeftCommand.
 */
public class LeftCommand implements CommandInterface {

  /* (non-Javadoc)
   * @see robotsim.Commands.CommandInterface#getCommand(java.lang.String)
   */
  @Override
  public Command getCommand(String cmdString) {
    Command command = new Command();
    command.setCommandText("LEFT");
    return command;
  }

}
