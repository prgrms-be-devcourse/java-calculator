package com.programmers.java.calculator.engine.io;

public interface Output {
    //계산결과 출력
    void inputError();

    void outputChoiceMessage();

    void outputCalculationResult(Double input);

    void calcError();
}
