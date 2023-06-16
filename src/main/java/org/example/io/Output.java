package org.example.io;

import java.util.List;

public interface Output {

    void printAction();
    void printCalculatedResult(double result);
    void printFindAll(List<String> strings);
    void printIoError();
    void printEquationError();
}
