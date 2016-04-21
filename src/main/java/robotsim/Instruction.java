package robotsim;

public interface Instruction {
  public Boolean validateInstruction(Command command, Robot robot, TableTop table);
  
  public void executeInstruction(Command command, Robot robot, TableTop table);
}
