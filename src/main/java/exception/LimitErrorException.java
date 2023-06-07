package exception;

public class LimitErrorException extends RuntimeException{
    private static final String MSG = "에러 시도 횟수가 5회가 넘었습니다.";

    public LimitErrorException() {
        super(MSG);
    }
}
