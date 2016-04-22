package robotsim;

/**
 * A factory for creating Instruction objects,
 * objects based on command text input. 
 */
public class InstructionFactory {
  
  /**
   * Gets the instruction.
   *
   * @param command the command
   * @return the instruction
   */
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
