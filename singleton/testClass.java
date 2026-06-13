package singleton;
import java.util.*;
public class testClass {
      public static void main(String[] args) {
            
            Logger log1=Logger.getInstance();
            Logger log2=Logger.getInstance();
            Logger log3=Logger.getInstance();
      System.out.println("No. of instance Created : "+Logger.instanceCounter);
      }
}

