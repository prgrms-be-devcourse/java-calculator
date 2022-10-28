package calculator.exception;

public class IllegalOperatorException extends RuntimeException {
    public IllegalOperatorException(){
        super("존재하지 않는 연산자입니다");
    }
}
