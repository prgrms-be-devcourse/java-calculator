package calculator.exception;

public class NotSolveEquationException extends RuntimeException{
    private static final String MSG = "방정식을 풀 수 없습니다.";

    public NotSolveEquationException() {
        super(MSG);
    }
}
