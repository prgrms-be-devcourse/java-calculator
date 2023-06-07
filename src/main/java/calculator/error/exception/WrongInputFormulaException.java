package calculator.error.exception;

import calculator.error.model.ResponseErrorFormat;

public class WrongInputFormulaException extends IllegalArgumentException {
    public WrongInputFormulaException(ResponseErrorFormat responseErrorFormat) {
        super(responseErrorFormat.getMessage());
    }
}
