package calculator.exception;

public class ApplicationException extends RuntimeException {
    private final ErrorMessage errorMessage;

    public ApplicationException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
