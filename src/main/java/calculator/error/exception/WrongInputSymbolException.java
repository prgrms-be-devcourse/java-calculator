package calculator.error.exception;

import calculator.error.model.ResponseErrorFormat;

public class WrongInputSymbolException extends IllegalArgumentException {
    public WrongInputSymbolException(ResponseErrorFormat responseErrorFormat) {
        super(responseErrorFormat.getMessage());
    }
}
