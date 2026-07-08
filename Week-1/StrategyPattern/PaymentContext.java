package StrategyPattern;

public class PaymentContext {  // executes different type of strategies dynamically
      private PaymentStrategy paymentStrategy; // it holds the reference to the strategy object
      public void setPaymentStrategy(PaymentStrategy paymentStrategy){  // it sets the strategy object
            this.paymentStrategy=paymentStrategy;
      }
      public void pay(int amount){  // it executes the strategy object dynamically
            paymentStrategy.pay(amount);
      }

}
