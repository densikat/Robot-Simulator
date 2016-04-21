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
   * Main method that runs simulator.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    
    printWelcome();
    
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
  private static void launchInteractive(Robot robot, TableTop table) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    InstructionFactory instructionFactory = new InstructionFactory();
    
    while (true) {
      String cmdString = br.readLine();
      Command cmd = new Command(cmdString);
      Instruction instruction = instructionFactory.getInstruction(cmd);
      if (!(instruction == null)) {
        robot.executeInstruction(cmd, instruction, table);
      }
    }
    
  }
  
  /**
   * Launch non interactive.
   *
   * @param path the path
   * @param robot the robot
   * @param table the table
   */
  private static void launchNonInteractive(String path, Robot robot, TableTop table) {
    
    InstructionFactory instructionFactory = new InstructionFactory();
    
    try (Stream<String> stream = Files.lines(Paths.get(path))) {

      // loop through each line input file and execute the command
      stream.forEach(item-> {
        Command cmd = new Command(item);
        Instruction instruction = instructionFactory.getInstruction(cmd);
        if (!(instruction == null)) {
          robot.executeInstruction(cmd, instruction, table);
        }
        
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
  
}
