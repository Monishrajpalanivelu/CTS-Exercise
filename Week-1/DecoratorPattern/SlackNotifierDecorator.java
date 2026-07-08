package DecoratorPattern;

public class SlackNotifierDecorator extends NottifierDecorator{
      private Nottifier nottifier;
      public SlackNotifierDecorator(Nottifier nottifier){
            super(nottifier); // calls NottifierDecorator constructor
            this.nottifier=nottifier;
      }
      public String sendNotification(){
            return nottifier.sendNotification()+" via , Slack Notifier"; // calls NottifierDecorator sendNotification and tells the state of it
      }
}
