package robotsim.Instructions;

import robotsim.Command;
import robotsim.Robot;
import robotsim.TableTop;

// TODO: Auto-generated Javadoc
/**
 * Represents an instruction.
 */
public interface Instruction {
  
  /**
   * Validate instruction.
   *
   * @param command the command to validate
   * @param robot the robot to validate the instruction against
   * @param table the table to validate the instruction against
   * @return true if valid, false if not valid
   */
  public Boolean validateInstruction(Command command, Robot robot, TableTop table);
  
  /**
   * Execute instruction.
   *
   * @param command the command
   * @param robot the robot to execute instruction
   * @param table the table to execute instruction on
   */
  public void executeInstruction(Command command, Robot robot, TableTop table);
}
