package CommandPattern;

public class LightOnCommand implements Command {
      private Light light;
      public LightOnCommand(Light light){
            this.light = light;
      }
      public void execute(){  // it executes the command object dynamically
            light.turnOn(); // turns on the light 
      }
}
