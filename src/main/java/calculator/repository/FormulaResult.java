package calculator.repository;

public class FormulaResult {

	private final String formula;
	private final String answer;

	public FormulaResult(String formula, String answer) {
		this.formula = formula;
		this.answer = answer;
	}

	public String getFormula() {
		return formula;
	}

	public String getAnswer() {
		return answer;
	}

	@Override
	public String toString() {
		return String.format("%s = %s", formula, answer);
	}
}
