package adapter;

public class testClass {
      public static void main(String[] args) {
            gpay gpay = new gpay();
            paymentProcess gpayAdapter = new gpayAdapter(gpay);
            gpayAdapter.processPayment("Processing payment through Gpay");

            paypal paypal = new paypal();
            paypalAdapter paypalAdapter = new paypalAdapter(paypal);
            paypalAdapter.processPayment("Processing payment through Paypal");

            
      }
}
