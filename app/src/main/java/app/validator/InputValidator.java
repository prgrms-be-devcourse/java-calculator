package app.validator;

import app.calculator.Select;
import app.exception.SelectInputValidateException;

// 사용자 입력값을 검증합니다.
public class InputValidator {

    // 처음 어떤 작업을 할지 선택하는 입력값을 검증합니다.
    public void validateSelectInput(Select selectInput) {
        if (selectInput != Select.LOOK_UP && selectInput != Select.CALCULATE && selectInput != Select.EXIT) {
            throw new SelectInputValidateException();
        }
    }
}
