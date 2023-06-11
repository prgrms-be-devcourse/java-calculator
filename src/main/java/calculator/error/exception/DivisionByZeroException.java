package calculator.error.exception;

import calculator.error.model.ResponseErrorFormat;

public class DivisionByZeroException extends RuntimeException {
    public DivisionByZeroException(ResponseErrorFormat responseErrorFormat) {
        super(responseErrorFormat.getMessage());
    }
}
