package StrategyPattern;

public class testClass {
      
      public static void main(String[] args) {
            PaymentContext paymentContext = new PaymentContext();
            paymentContext.setPaymentStrategy(new CreditCardPayment("sibi"));
            paymentContext.pay(1000);
            paymentContext.setPaymentStrategy(new PayPalPayment("sibi"));
            paymentContext.pay(2000);
      }
}
