package calculation;

import static com.google.common.base.Preconditions.*;

import java.util.Objects;

public class Record {

	private String originExpression;
	private String result;

	public Record(String originExpression, String result) {
		checkArgument(originExpression != null, "originExpression 이 반드시 제공되어야 합니다");
		checkArgument(result != null, "result 가 반드시 제공되어야 합니다.");

		this.originExpression = originExpression;
		this.result = result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Record record = (Record)o;

		return originExpression.equals(record.originExpression);
	}

	@Override
	public int hashCode() {
		return Objects.hash(originExpression);
	}

	@Override
	public String toString() {
		return originExpression + " = " + result;
	}

	public String getOriginExpression() {
		return originExpression;
	}

	public String getResult() {
		return result;
	}
}
