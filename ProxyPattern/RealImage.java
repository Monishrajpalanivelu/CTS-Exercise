package ProxyPattern;

public class RealImage implements image {
      private String fileName;
      public RealImage(String fileName){ // it takes time to load real image so we will use proxy pattern to lazy load 
            this.fileName = fileName;
            loadFromServer(fileName); // load from server
      }
      public void display(){
            System.out.println("Displaying " + fileName); // display image
      }
      private void loadFromServer(String fileName){ // it takes time to load real image so we will use proxy pattern to lazy load
            System.out.println("Loading " + fileName + " from server"); // load from disk
      }
}
