package calculator.validator;

public interface Validator {

	boolean isNumber(String s);

	boolean isFormula(String s);

	boolean isDivideZero(String s);

}
