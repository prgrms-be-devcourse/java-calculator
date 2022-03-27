package service;

import java.util.ArrayList;

public interface CalculatorService {

    void input();
    double calculate(String postfix);

    void getResults();

    ArrayList<Object> toPostfix(String expression);

    boolean checkPriority(Character a,Character b);
}
