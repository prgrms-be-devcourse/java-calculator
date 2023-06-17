package io;

import java.util.List;

public interface Output {

    void inputEmptyError(String inputString);
    void historyEmptyError();
    boolean showResultHistory(List<String> history);
    void printMenuList();
    void printInvalidMenuErrorMessage();
    void printResult(String result);
    void printInputExpressionMessage();
    void printEmptyInputExpressionMessage();

}
