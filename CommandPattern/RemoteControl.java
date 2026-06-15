package CommandPattern;
import java.util.*;
public class RemoteControl {
      Command operation;
      List<Command> list = new ArrayList<>(); // it holds all the command objects
      public void addCommand(Command commandOperation){ // it adds the command object
            list.add(commandOperation);
            this.operation=commandOperation;  // it holds the reference to the last added command object
      }    
      public void executeCommand(){ // it executes the command object
            operation.execute(); // it executes the command object
      }
}
