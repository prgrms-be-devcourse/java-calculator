package io;

import java.util.List;

public interface Output {

    void inputEmptyError(String inputString);
    void historyEmptyError();
    boolean showResultHistory(List<String> history);
    void printMenuList();
    void printResult(Integer result);

}
