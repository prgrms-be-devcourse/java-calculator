package calculator.exception;

public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException(){
        super("존재하지 않는 명령어입니다");
    }
}
