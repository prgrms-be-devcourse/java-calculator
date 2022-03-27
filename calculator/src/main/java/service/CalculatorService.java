package service;

public interface CalculatorService {
    void calculate();

    void getResults();

    String toPostfix(String expression);

    boolean checkPriority(Character a,Character b);
}
