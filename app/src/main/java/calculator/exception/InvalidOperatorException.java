package calculator.exception;

public class InvalidOperatorException extends RuntimeException {
    public InvalidOperatorException(){
        super("존재하지 않는 연산자입니다");
    }
}
