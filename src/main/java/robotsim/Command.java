package robotsim;

public class Command {
  private String commandText;
  private int xCoordinate;
  private int yCoordinate;
  private Simulator.direction direction;
  
  public Command(String cmdText) {
    commandText = cmdText;
  }
  public Command(String cmdText, int x, int y, Simulator.direction dir) {
   commandText = cmdText;
   xCoordinate = x;
   yCoordinate = y;
   direction = dir;
  }
  
  public String getCommandText() {
    return commandText;
  }
  
  public int getXcoordinate() {
    return xCoordinate;
  }
  
  public int getYcoordinate() {
    return yCoordinate;
  }
  
  public Simulator.direction getDirection() {
    return direction;
  }
}
