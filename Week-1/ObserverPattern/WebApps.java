package ObserverPattern;

public class WebApps implements Observer { 
      private String name;
      public WebApps(String name){
            this.name = name;
      }
      public void update(String msg){  // recieves notification from the publisher and doesnt needs to check for the update on their own
            System.out.println("Hey " + name + ", " + msg); 
      }
}
