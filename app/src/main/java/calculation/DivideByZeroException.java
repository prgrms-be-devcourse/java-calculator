package calculation;

public class DivideByZeroException extends IllegalArgumentException {

	public DivideByZeroException() {
		super("NaN.....0으로 나눌 수 없습니다");
	}
}
