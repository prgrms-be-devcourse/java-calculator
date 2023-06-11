package calculator.error.exception;

import calculator.error.model.ResponseErrorFormat;

public class WrongInputMenuException extends IllegalArgumentException {
    public WrongInputMenuException(ResponseErrorFormat responseErrorFormat) {
        super(responseErrorFormat.getMessage());
    }
}
