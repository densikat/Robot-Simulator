package robotsim;

public class Simulator {
  
  public enum direction {
    NORTH, SOUTH, EAST, WEST
  };

  public static void main(String[] args) {
    RobotDemo mrRobot = new RobotDemo(1, 1, direction.NORTH);
    printMenu();
    TableTop table = new TableTop(4,4);
    Command moveCommand = new Command("MOVE");
    processCommand(mrRobot, moveCommand, table);
  }

  private static void printMenu() {
    System.out.println("Welcome to Robot Simulator");
  }

  private static void processCommand(IRobot robot, Command command, TableTop table) {
    if (robot.validateCommand(command, table)) {
      robot.executeCommand(command, table);
    }
  }
  
}
