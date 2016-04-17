package robotsim;

import java.nio.file.*;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Simulator {
  
  public enum direction {
    NORTH("NORTH"), SOUTH("SOUTH"), EAST("EAST"), WEST("WEST");
    
    private final String name;

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
  
  private static void launchInteractive(IRobot robot, TableTop table) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    while (true) {
      String cmdString = br.readLine();
      Command cmd = new Command(cmdString);
      processCommand(robot, cmd, table);
    }
    
  }
  
  private static void launchNonInteractive(String path, IRobot robot, TableTop table) {
    try (Stream<String> stream = Files.lines(Paths.get(path))) {

      // loop through each line input file and execute the command
      stream.forEach(item->{
        Command cmd = new Command(item);
        processCommand(robot, cmd, table);
      });

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  private static void printPathInvalidHelp() {
    System.out.println("The path you entered was invalid:");
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
    System.out.println("Welcome to Robot Simulator!");
  }

  private static void processCommand(IRobot robot, Command command, TableTop table) {
    if (robot.validateCommand(command, table)) {
      robot.executeCommand(command, table);
    }
  }
  
}
