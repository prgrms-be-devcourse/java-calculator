package calculator.filter;

import java.util.Stack;

public interface Filter {
    int isSelect(String line);
    String clearSpace(String line);
    Stack<String> changeStringToStack(String s);
    String formatResult(double calculateResult);
    String keyMapping(String s);
    boolean validate(String s);
}
