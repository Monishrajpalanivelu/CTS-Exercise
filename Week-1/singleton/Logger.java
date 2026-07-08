package singleton;
public class Logger  {
      private static Logger log;
      public static int instanceCounter=0;
      private Logger(){
            instanceCounter++;
      }
      public static Logger getInstance(){
            if(log==null){
                  log=new Logger();
                  System.out.println("Instance Created");
            }
            else{
                  System.out.println("Instance Already Exits");
            }
            
            return log;
      }
          public void log(String message) {
        System.out.println("LOG: " + message);
    }

}
