package Result;

public class Result {
    private Throwable error;
    public boolean hasError() {
        return this.error != null;
    }
    public Result(ErrorCode errorCode) {
        error = new RuntimeException(errorCode.getMessage());
    }
    public void printError() {
        System.out.println(error.getMessage());
    }
    public Result() {
        this.error = null;
    }
}
