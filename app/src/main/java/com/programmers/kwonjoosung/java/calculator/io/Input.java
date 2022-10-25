package com.programmers.kwonjoosung.java.calculator.io;

import java.util.Scanner;

public interface Input {
    int inputMenu();
    String inputExpression();
    void inputNext();
    void setScanner(Scanner scanner); // Test 하기 위해 인터페이스에 정의해도 괜찮은건지..?
}
