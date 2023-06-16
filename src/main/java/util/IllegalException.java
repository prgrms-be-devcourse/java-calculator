package util;

public class IllegalException extends RuntimeException{
    public IllegalException(ExceptionMsg msg) {
        super(msg.getMsg());
    }
}
