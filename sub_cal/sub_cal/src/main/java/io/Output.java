package io;

import java.util.List;

public interface Output {

    void inputEmptyError(String inputString);
    void historyEmptyError();
    boolean showResultHistory(List<String> history);
    void ShowOptions();
    void printResult(Integer result);

}
