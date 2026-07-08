package DecoratorPattern;

public class testClass {
      public static void main(String[] args) {
            //single object but multiple responsibilities/states and we can add them dynamically without creating new objects that is the principle of decorator pattern 
            Nottifier nottifier = new EmailNottifier(); // base class object
            System.out.println(nottifier.sendNotification()); // calls base class sendNotification
            nottifier = new SMSNotifierDecorator(nottifier); // calling decorator
            System.out.println(nottifier.sendNotification()); // calls NottifierDecorator sendNotification and tells the state of it
            nottifier = new SlackNotifierDecorator(nottifier); // calling decorator
            System.out.println(nottifier.sendNotification()); // calls NottifierDecorator sendNotification and tells the state of it
      }
}
