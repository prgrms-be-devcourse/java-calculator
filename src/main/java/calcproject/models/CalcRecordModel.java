package calcproject.models;

public class CalcRecordModel {

	private int id;
	private String expression;
	private double calcResult;

	public CalcRecordModel(String expression, double calcResult) {
		this.expression = expression;
		this.calcResult = calcResult;
	}

	@Override
	public String toString() {
		return this.expression + " = " + this.calcResult;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof CalcRecordModel))
			return false;

		CalcRecordModel calcRecordModel = (CalcRecordModel)o;
		return this.calcResult == calcRecordModel.getCalcResult() &&
			this.expression.equals(calcRecordModel.getExpression());
	}
}
