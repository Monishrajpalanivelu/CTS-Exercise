package DecoratorPattern;

public class SMSNotifierDecorator extends NottifierDecorator{
      private Nottifier nottifier;
      public SMSNotifierDecorator(Nottifier nottifier){
            super(nottifier); // calls NottifierDecorator constructor
            this.nottifier=nottifier;
      }
      public String sendNotification(){
            return nottifier.sendNotification()+" via , SMS Notifier"; // calls NottifierDecorator sendNotification and tells the state of it
      }
}
