package robotsim.Commands;

import robotsim.Direction;
import robotsim.Robot;
import robotsim.TableTop;

/**
 * Command to place robot on the table
 */
public class PlaceCommand extends Command {

  /* (non-Javadoc)
   * @see robotsim.Commands.Command#initializeCommand(java.lang.String)
   */
  @Override
  public void initializeCommand(String cmdString) {
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
    Direction direction = new Direction();
    
    // If input direction is not valid throw exception
    if (validCommand) {
      if (!direction.validateDirection(splitArgs[2])) {
        validCommand = false;
      }
    }
    
    if (validCommand) {
      
      this.setCommandWidth(Integer.parseInt(splitArgs[0]));
      this.setCommandHeight(Integer.parseInt(splitArgs[1]));
      this.setCommandText("PLACE");
      this.setDirection(direction.getDirectionIndex(splitArgs[2]));
    }

  }

  /* (non-Javadoc)
   * @see robotsim.Commands.Command#validateInstruction(robotsim.Robot, robotsim.TableTop)
   */
  @Override
  public Boolean validateInstruction(Robot robot, TableTop table) {
    Boolean returnVal = false;

    if (!(this.getCommandText().equals("INVALID"))) {
      // Validate position
      if (this.getXcoordinate() <= table.getTableWidth() && this.getXcoordinate() >= 0) {
        if (this.getYcoordinate() <= table.getTableHeight() && this.getYcoordinate() >= 0) {

          // Validate no robots on table
          if (table.getCurrentRobot() == null) {
            returnVal = true;
          }
        }
      }
    }
    return returnVal;
  }

  /* (non-Javadoc)
   * @see robotsim.Commands.Command#executeInstruction(robotsim.Robot, robotsim.TableTop)
   */
  @Override
  public void executeInstruction(Robot robot, TableTop table) {
    robot.setCurrentWidth(this.getXcoordinate());
    robot.setCurrentHeight(this.getYcoordinate());
    robot.setDirection(this.getDirection());
    table.setCurrentRobot(robot);
  }

}
