package CommandPattern;

public class testClass {
      public static void main(String[] args) {
            RemoteControl remoteControl = new RemoteControl();
            Light light = new Light("Light");
            remoteControl.addCommand(new LightOnCommand(light));
            remoteControl.executeCommand();
            remoteControl.addCommand(new LightOffCommand(light));
            remoteControl.executeCommand();     
      }
}
