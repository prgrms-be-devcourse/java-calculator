package calculator.domain;

import java.util.List;

public interface Calculator {
    List<String> getAllData();
    String calculate(String expression);
}