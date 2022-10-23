package engine.exception;

public class notValidInputException extends RuntimeException{
    public notValidInputException() {
        super();
    }

    public notValidInputException(String message) {
        super(message);
    }

    public notValidInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
