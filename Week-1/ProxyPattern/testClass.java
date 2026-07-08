package ProxyPattern;

public class testClass {      
      public static void main(String[] args) {
            image image = new proxyImage("test.jpg");
            image.display(); // it will load the image only when display is called
           image.display(); // it will not load the image again because it is already loaded
      }
}
