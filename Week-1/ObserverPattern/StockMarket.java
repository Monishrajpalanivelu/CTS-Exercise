package ObserverPattern;
import java.util.*;
public class StockMarket implements Stock {
      private List<Observer> list;
      public StockMarket(){ // it takes time to load real image so we will use proxy pattern to lazy load 
            this.list = new ArrayList<>();
      }
      public void register(Observer observer){
            list.add(observer);
      }
      public void unregister(Observer observer){
            list.remove(observer);
      }
      public void notifyObserver(String msg){
            for(Observer observer : list){
                  observer.update(msg); // notifies all the subscribers
            }
      } 
      
}