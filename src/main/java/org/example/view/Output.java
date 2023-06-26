package org.example.view;

import java.util.List;

public interface Output {

    void printSelection();

    void printResult(double result);

    void printRecords(List<String> arithmeticRecords);
}
