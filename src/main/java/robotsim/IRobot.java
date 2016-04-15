/**
 * 
 */
package robotsim;

/**
 * @author David Ensikat
 *
 */
public interface IRobot {
  Boolean validateCommand(Command command, TableTop table);
  void executeCommand(Command command);
}
