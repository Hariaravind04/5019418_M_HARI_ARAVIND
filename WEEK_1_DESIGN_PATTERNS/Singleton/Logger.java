public class Logger {
    private static volatile Logger instance;
    private Logger(){

    }

    //Lazy intialization with double check
    public static Logger getInstance(){
        if(instance==null){
            synchronized(Logger.class){
                if(instance==null){
                    instance= new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String Message){
        System.out.println(Message);
    }

}
