package calculator.validation;

public interface Validation {
    boolean isOperator(String str);
    boolean divideByZero(String operator,double number);
}
