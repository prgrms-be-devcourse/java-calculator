package calculator.validator;

import java.util.regex.Pattern;

public class FormulaValidator implements Validator {

	private static final Pattern numberPattern = Pattern.compile("^\\d*$");
	private static final Pattern formulaPattern = Pattern.compile("^(\\d+[+*/-])+(\\d+)");

	@Override
	public boolean isNumber(String s) {
		return numberPattern.matcher(s).matches();
	}

	@Override
	public boolean isFormula(String s) {
		return formulaPattern.matcher(s).matches();
	}

}
