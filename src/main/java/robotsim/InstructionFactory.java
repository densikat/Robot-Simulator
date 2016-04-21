package robotsim;

public class InstructionFactory {
  public Instruction getInstruction(Command command) {
    
    Instruction instruction = null;
    
    switch (command.getCommandText()) {
      case "PLACE":
        instruction = new PlaceInstruction();
        break;
      case "LEFT":
        instruction = new LeftInstruction();
        break;
      case "RIGHT":
        instruction = new RightInstruction();
        break;
      case "REPORT":
        instruction = new ReportInstruction();
        break;
      case "MOVE":
        instruction = new MoveInstruction();
        break;
      default:
        break;
    }
    
    return instruction;
  }
}
