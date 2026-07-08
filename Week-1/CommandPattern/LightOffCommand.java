package CommandPattern;

public class LightOffCommand implements Command{
      private Light light;
      public LightOffCommand(Light light){ // this is the command object 
            this.light = light; // 
      }
      public void execute(){ // this is the execute method 
            light.turnOff(); // it turns off the light 
      }
}
