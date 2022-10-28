package calculator.exception;

public class NoCommandException extends RuntimeException {
    public NoCommandException(){
        super("존재하지 않는 명령어입니다");
    }
}
