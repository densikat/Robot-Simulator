package robotsim.Commands;

import robotsim.Command;

// TODO: Auto-generated Javadoc
/**
 * The Class ReportCommand.
 */
public class ReportCommand implements CommandInterface {

  /* (non-Javadoc)
   * @see robotsim.Commands.CommandInterface#getCommand(java.lang.String)
   */
  @Override
  public Command getCommand(String cmdString) {
    Command command = new Command();
    command.setCommandText("REPORT");
    return command;
  }

}
