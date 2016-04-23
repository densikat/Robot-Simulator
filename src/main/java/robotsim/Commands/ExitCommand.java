package robotsim.Commands;

import robotsim.Robot;
import robotsim.TableTop;

public class ExitCommand extends Command {

  @Override
  public void initializeCommand(String cmdString) {
    this.setCommandText("EXIT");
  }

  @Override
  public Boolean validateInstruction(Robot robot, TableTop table) {
    return true;
  }

  @Override
  public void executeInstruction(Robot robot, TableTop table) {
    System.exit(0);
  }

}
