package robotsim;

public class Simulator {

  private static final int tableTopX = 4; // How far the robot is allowed to move on the x-axis
  private static final int tableTopY = 4; // How far the robot is allowed to move on the y-axis

  public static void main(String[] args) {

    RobotDemo mrRobot = new RobotDemo(1, 1, RobotDemo.direction.NORTH);
    printMenu();
    processCommand(mrRobot, "MOVE");
  }

  private static void printMenu() {
    System.out.println("Welcome to Robot Simulator");
  }

  private static void processCommand(IRobot robot, String command) {
    if (robot.validateCommand(command, tableTopX, tableTopY)) {
      robot.executeCommand(command);
    }

  }
}
