package app.io;

import app.calculator.Answer;

// 사용자 출력값
public interface Output {
    void selectOutput(String selectNumber);
    void lookUpOutput(String calculateHistory);
    void calculateOutput(Answer calculateResult);
    void inputError();
    void calculateError();
    void quitProgram();
}
