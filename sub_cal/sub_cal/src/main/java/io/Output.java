package io;

import java.util.List;

public interface Output {

    void historyEmptyError();
    boolean showResultHistory(List<String> history);
    void printMenuList();
    void printResult(String result);
    void printInputExpressionMessage();


}
