/**
 * 
 */
package robotsim;

/**
 * @author David Ensikat
 *
 */
public interface IRobot {
  Boolean validateCommand(String command, int xConstraint, int yConstraint);

  void executeCommand(String command);
}
