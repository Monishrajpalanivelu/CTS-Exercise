package CommandPattern;

public class Light {
      private String name;
      public Light(String name){
            this.name = name;
      }
      public void turnOn(){ // it turns on the light 
            System.out.println(name + " is turned on");
      }
      public void turnOff(){ // it turns off the light
            System.out.println(name + " is turned off");
      }
}
