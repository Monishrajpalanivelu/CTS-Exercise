package ProxyPattern;

public class proxyImage implements image{
      private RealImage realImage;
      private String fileName;
      public proxyImage(String fileName){
            this.fileName = fileName;
      }
      public void display(){
            if(realImage == null){ // check if real image is loaded
                  realImage = new RealImage(fileName); // load real image only if not loaded
            }
            realImage.display(); // display real image
      }
}
