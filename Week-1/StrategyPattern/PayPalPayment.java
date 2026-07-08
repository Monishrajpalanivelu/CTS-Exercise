package StrategyPattern;

public class PayPalPayment implements PaymentStrategy {
      String name;
      public PayPalPayment(String name){
            this.name = name;
      }
      public void pay(int amount){
            System.out.println(name + " is using PayPalPayment to pay " + amount);
      }
}
