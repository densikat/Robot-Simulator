package robotsim;

public interface Instruction {
  public Boolean validateInstruction(Command command, RobotDemo robot, TableTop table);
  
  public void executeInstruction(Command command, RobotDemo robot, TableTop table);
}
