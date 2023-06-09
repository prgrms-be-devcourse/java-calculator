package com.programmers.junho.view;

import java.util.List;

public interface OutputView {

    void printChoiceMessage();
    void printExpressions(List<String> expressions);

    void printCalculatedResult(int result);
}
