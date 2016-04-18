package robotsim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;
import java.nio.file.*;


/**
 * The Class Simulator.
 */
public class Simulator {
  
  /**
   * Direction enum. Used for robot directional heading on TableTop
   */
  public enum direction {
    
    /** The north. */
    NORTH("NORTH"), 
    /** The south. */
    SOUTH("SOUTH"), 
    /** The east. */
    EAST("EAST"), 
    /** The west. */
    WEST("WEST");
    
    /** The name. */
    private final String name;

    /**
     * Instantiates a new direction.
     *
     * @param s the s
     */
    private direction(String s) {
      name = s;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    public String toString() {
      return this.name;
    }
  }

  /**
   * Main method that runs simulator.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    
    printWelcome();
    
    TableTop table = new TableTop(4,4);
    
    RobotDemo mrRobot = new RobotDemo();
    
    if (args.length == 1) {
      
      Path path = Paths.get(args[0]);
      
      if (Files.exists(path)) {
        launchNonInteractive(path.toString(), mrRobot, table);
      } else {
        printPathInvalidHelp();
      }
      
    } else if (args.length > 1) {
      printTooManyArguments();
    } else {
      
      try {
        launchInteractive(mrRobot, table);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
  }
  
  /**
   * Launch interactive.
   *
   * @param robot the robot
   * @param table the table
   * @throws IOException Signals that an I/O exception has occurred.
   */
  private static void launchInteractive(RobotDemo robot, TableTop table) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    while (true) {
      String cmdString = br.readLine();
      Command cmd = new Command(cmdString);
      processCommand(robot, cmd, table);
    }
    
  }
  
  /**
   * Launch non interactive.
   *
   * @param path the path
   * @param robot the robot
   * @param table the table
   */
  private static void launchNonInteractive(String path, RobotDemo robot, TableTop table) {
    try (Stream<String> stream = Files.lines(Paths.get(path))) {

      // loop through each line input file and execute the command
      stream.forEach(item-> {
        Command cmd = new Command(item);
        processCommand(robot, cmd, table);
      });

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Prints the path invalid help.
   */
  private static void printPathInvalidHelp() {
    System.out.println("The path you entered was invalid:");
    System.out.println("Usage:");
    System.out.println("File input mode: java robotsim pathtofile");
  }
  
  /**
   * Prints the too many arguments.
   */
  private static void printTooManyArguments() {
    System.out.println("You entered two many arguments:");
    System.out.println("Usage:");
    System.out.println("Interactive: java robotsim");
    System.out.println("File input mode: java robotsim pathtofile");
  }

  /**
   * Prints the welcome.
   */
  private static void printWelcome() {
    System.out.println("Welcome to Robot Simulator!");
  }

  /**
   * Takes a command and then validates it via robot
   * If command is valid then command is executed.
   *
   * @param robot the robot
   * @param command the command
   * @param table the table
   */
  private static void processCommand(RobotDemo robot, Command command, TableTop table) {
    if (robot.validateCommand(command, table)) {
      robot.executeCommand(command, table);
    }
  }
  
}
