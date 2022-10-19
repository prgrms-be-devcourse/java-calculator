package src.log;


public class Log {
    private String str;

    private Log(){};
    public static Log createLog(String expression, String answer){
        Log log = new Log();
        log.str = expression + " = " + answer;
        return log;
    }

    @Override
    public String toString() {
        return str;
    }
}
