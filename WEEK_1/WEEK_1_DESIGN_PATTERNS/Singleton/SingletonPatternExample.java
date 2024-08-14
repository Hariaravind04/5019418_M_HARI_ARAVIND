public class SingletonPatternExample {
    public static void main(String[] args) {
        Logger log1=Logger.getInstance();
        Logger log2=Logger.getInstance();

        if(log1==log2){
            System.out.println("Same instance");
        }
        else{
            System.out.println("Different instances");
        }

        log1.log("Message from instance log 1");
        log2.log("Message from instance log 2");
    }
}
