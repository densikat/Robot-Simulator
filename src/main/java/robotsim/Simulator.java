package robotsim;

import java.nio.file.*;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class Simulator {
  
  public enum direction {
    NORTH("NORTH"), SOUTH("SOUTH"), EAST("EAST"), WEST("WEST");
    
    private final String name;       
    private Boolean interactive;

    private direction(String s) {
        name = s;
    }
    
    public String toString() {
      return this.name;
   }
  }

  public static void main(String[] args) {
    
    printWelcome();
    
    // Initialize table
    
    TableTop table = new TableTop(4,4);
    
    RobotDemo mrRobot = new RobotDemo(0,0,direction.NORTH);
    
    Command placeCmd = new Command("PLACE 0,0,NORTH");
    Command report = new Command("REPORT");
    
    processCommand(mrRobot, placeCmd, table);
    processCommand(mrRobot, report, table);
    
    if (args.length == 1) {
      
      Path path = Paths.get(args[0]);
      
      if (Files.exists(path)) {
        launchNonInteractive();
      } else {
        printPathInvalidHelp();
      }
      
    } else if (args.length > 1) {
      printTooManyArguments();
    } else {
      launchInteractive();
    }
    
    // Parse arguments
    // Set interactive to true if interactive or false if not
    // If not interactive then validate file path and read or error
    
    // Print welcome message
    
    // If interactive mode then start interactive loop
    // If file input mode then process commands from file
    
  }
  
  private static void launchInteractive() {
    
  }
  
  private static void launchNonInteractive() {
    
  }
  
  private static void printPathInvalidHelp() {
    System.out.println("The path you input was invalid:");
    System.out.println("Usage:");
    System.out.println("File input mode: java robotsim pathtofile");
  }
  
  private static void printTooManyArguments() {
    System.out.println("You entered two many arguments:");
    System.out.println("Usage:");
    System.out.println("Interactive: java robotsim");
    System.out.println("File input mode: java robotsim pathtofile");
  }

  private static void printWelcome() {
    System.out.println("Welcome to Robot Simulator");
  }

  private static void processCommand(IRobot robot, Command command, TableTop table) {
    if (robot.validateCommand(command, table)) {
      robot.executeCommand(command, table);
    }
  }
  
}
