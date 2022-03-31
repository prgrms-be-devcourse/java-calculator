package Validator;

public interface Validator {
    boolean validate(String expression);
    default boolean isDivZero(String expression) {
        boolean contains = expression.contains("/0");
        return contains;
    }
}
