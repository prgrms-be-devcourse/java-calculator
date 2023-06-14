package exception;

public class NoSuchCommandException extends RuntimeException {
    public NoSuchCommandException() {
    }

    public NoSuchCommandException(String message) {
        super(message);
    }
}
