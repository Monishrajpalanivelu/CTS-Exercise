package DecoratorPattern;

public class NottifierDecorator implements Nottifier {
      private Nottifier nottifier;
      public NottifierDecorator(Nottifier nottifier){
            this.nottifier=nottifier; // takes reference of the object
      }
      public String sendNotification(){
            return nottifier.sendNotification(); // calls nottifier sendNotification
      }
     
}
