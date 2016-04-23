package robotsim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import robotsim.Commands.Command;
import robotsim.Commands.CommandFactory;

import java.nio.file.*;

/**
 * Simulator class launches and controls execution flow of game.
 */
public class Simulator {
  
  /**
   * Main method that runs simulator.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    
    printWelcomeMessage();
    
    TableTop table = new TableTop(4,4);
    
    Robot mrRobot = new Robot();
    
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
      } catch (IOException ioException) {
        ioException.printStackTrace();
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
  private static void launchInteractive(Robot robot, TableTop table) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    while (true) {
      String cmdString = br.readLine();
      processCommand(cmdString, robot, table);
    }
    
  }
  
  /**
   * Launch non interactive.
   *
   * @param path the path to file with commands
   * @param robot the robot
   * @param table the table
   */
  private static void launchNonInteractive(String path, Robot robot, TableTop table) {
    
    try (Stream<String> stream = Files.lines(Paths.get(path))) {

      // loop through each line input file and execute the command
      stream.forEach(cmdString-> {
        processCommand(cmdString, robot, table);
      });

    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }
  
  /**
   * Take command string
   * Use command factory to generate command object
   * If valid then send to robot to execute command
   *
   * @param cmdString the cmd string
   * @param robot the robot
   * @param table the table
   */
  private static void processCommand(String cmdString, Robot robot, TableTop table) {
    
    CommandFactory commandFactory = new CommandFactory();
    Command command = commandFactory.getCommand(cmdString);
    
    // If we have a valid command back then send it to robot to execute
    if (!(command == null)) {
      robot.executeInstruction(command, table);
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
  private static void printWelcomeMessage() {
    System.out.println("Welcome to Robot Simulator!");
  }
  
}
