package exception;

public class NotMenuFormatExcpetion extends RuntimeException{
    private static final String msg = "메뉴 형식이 아닙니다.";
    public NotMenuFormatExcpetion() {
        super(msg);
    }
}
