package robotsim;

import java.io.BufferedReader;
import java.io.Console;
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
    
    RobotDemo mrRobot = new RobotDemo(1, 1, direction.NORTH);
    printMenu();
    TableTop table = new TableTop(4,4);
    
    Command moveCommand = new Command("MOVE");
    Command placeCommand = new Command("PLACE",0,0,direction.NORTH);
    Command reportCommand = new Command("REPORT");
    
    processCommand(mrRobot, placeCommand, table);
    processCommand(mrRobot, reportCommand, table);
    processCommand(mrRobot, moveCommand, table);
    processCommand(mrRobot, reportCommand, table);
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
