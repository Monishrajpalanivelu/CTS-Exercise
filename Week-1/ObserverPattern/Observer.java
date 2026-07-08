package ObserverPattern;

public interface Observer {
      public void update(String msg); // recieves notification from the publisher and doesnt needs to check for the update on their own
}
