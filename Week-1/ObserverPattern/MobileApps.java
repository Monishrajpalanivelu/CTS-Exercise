package ObserverPattern;

public class MobileApps implements Observer { 
      private String name;
      public MobileApps(String name){
            this.name = name;
      }
      public void update(String msg){  // recieves notification from the publisher and doesnt needs to check for the update on their own
            System.out.println("Hey " + name + ", " + msg); 
      }
}
