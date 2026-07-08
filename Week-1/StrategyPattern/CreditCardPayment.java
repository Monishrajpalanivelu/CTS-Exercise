package StrategyPattern;

public class CreditCardPayment implements PaymentStrategy {
      String name;
      public CreditCardPayment(String name){
            this.name = name;
      }
      public void pay(int amount){
            System.out.println(name + " is using CreditCardPayment to pay " + amount);
      }
}
