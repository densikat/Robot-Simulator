package robotsim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import robotsim.Commands.CommandFactory;
import robotsim.Instructions.Instruction;
import robotsim.Instructions.InstructionFactory;

import java.nio.file.*;

// TODO: Auto-generated Javadoc
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
   * @param path the path
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
   * Process command.
   *
   * @param cmdString the cmd string
   * @param robot the robot
   * @param table the table
   */
  private static void processCommand(String cmdString, Robot robot, TableTop table) {
    InstructionFactory instructionFactory = new InstructionFactory();
    CommandFactory commandFactory = new CommandFactory();
    
    Command cmd = commandFactory.getCommand(cmdString); // Get command object
    if (!(cmd == null)) { // if command object is valid
      Instruction instruction = instructionFactory.getInstruction(cmd); // then get the instruction
      if (!(instruction == null)) { // if the instruction is valid
        robot.executeInstruction(cmd, instruction, table); // execute instruction
      }
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
