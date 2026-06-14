package adapter;

public class gpayAdapter implements paymentProcess{
      private gpay gpay;
      public gpayAdapter(gpay gpay){
            this.gpay=gpay;
      }
      public void processPayment(String str){
          gpay.processGpay(str);
      }
}
