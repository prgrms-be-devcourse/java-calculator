package com.programmers.blackdog.view;

import java.util.List;

public class Console {

    private static final String CHOICE_MESSAGE = "1. 조회\n" + "2. 계산\n" + "3. 종료\n";

    private final InputView inputView;
    private final OutputView outputView;

    public Console(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int getSelectionCode() {
        outputView.print(CHOICE_MESSAGE);
        outputView.print("선택 : ");
        try {
            return Integer.parseInt(inputView.read());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("잘못된 값을 입력하셨습니다.");
        }
    }


    public void printExpressions(List<String> calculatedData) {
        validateIfIsEmpty(calculatedData);
        outputView.print(calculatedData);
    }

    private void validateIfIsEmpty(List<String> expressions) {
        if (expressions.isEmpty()) {
            outputView.print("계산 값이 존재하지 않습니다.");
        }
    }

    public String getExpression() {
        outputView.print("식 : ");
        return inputView.read();
    }

    public void printCalculatedResult(int result) {
        outputView.print(result);
    }

    public void printEndMessage() {
        outputView.print("프로그램을 종료합니다.");
    }

    public void printErrorMessage(String message) {
        outputView.print(message);
    }
}
