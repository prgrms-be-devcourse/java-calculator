package calculator.exception;

public class DividedByZeroException  extends RuntimeException {
    public DividedByZeroException(){
        super("0으로 나눌 수 없습니다");
    }
}
