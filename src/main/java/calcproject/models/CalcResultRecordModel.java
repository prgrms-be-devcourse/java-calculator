package calcproject.models;

public class CalcResultRecordModel {

	private int id;
	private String expression;
	private double calcResult;

	public CalcResultRecordModel(String expression, double calcResult) {
		this.expression = expression;
		this.calcResult = calcResult;
	}

	public String getExpression() {
		return this.expression;
	}

	public double getCalcResult() {
		return this.calcResult;
	}

	public int getId() {
		return this.id;
	}
}
