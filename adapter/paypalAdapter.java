package adapter;

public class paypalAdapter implements paymentProcess{
      private paypal payPal;
      public paypalAdapter(paypal payPal){
            this.payPal=payPal;
      }
      public void processPayment(String str){
          payPal.sendMoney(str);
      }
}
