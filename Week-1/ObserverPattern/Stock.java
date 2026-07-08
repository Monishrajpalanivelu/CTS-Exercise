package ObserverPattern;

public interface Stock {
      public void register(Observer observer); 
      public void unregister(Observer observer);
      public void notifyObserver(String msg);
}
