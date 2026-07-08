package ObserverPattern;

public class testClass {
      public static void main(String[] args){  // Main Class
            Stock stockMarket = new StockMarket();
            Observer mobileApps = new MobileApps("MobileApps");
            Observer webApps = new WebApps("WebApps");
            stockMarket.register(mobileApps);  // registering the observers
            stockMarket.register(webApps);  // registering the observers
            stockMarket.notifyObserver("Stock market has been updated");  // notifying all the observers
            stockMarket.unregister(webApps);  // unregistering the observers
            stockMarket.notifyObserver("Stock market has been updated");  // notifying all the observers
      }
}
