package robotsim;

public class ReportInstruction implements Instruction {

  @Override
  public Boolean validateInstruction(Command command, Robot robot, TableTop table) {
    if (table.getCurrentRobot() == robot) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void executeInstruction(Command command, Robot robot, TableTop table) {
    Direction dir = new Direction();
    
    String toWrite = String.format("%s,%s,%s", Integer.toString(robot.getCurrentX()),
        Integer.toString(robot.getCurrentY()), dir.getDirection(robot.getDirection()));
    System.out.println(toWrite);

  }

}
