package DecoratorPattern;

public class EmailNottifier implements Nottifier {

      @Override
      public String sendNotification() { // base class sendNotification
            return " Email Notification  ";
      }
      
}
