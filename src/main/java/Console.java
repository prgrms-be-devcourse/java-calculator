import calculator.engine.io.Input;
import calculator.engine.io.Output;

public class Console implements Input, Output {
    @Override
    public String input(String s) {
        return null;
    }
    @Override
    public String inputError() {
        return "입력 오류가 발생하였습니다.";
    }
    @Override
    public String outputError() {
        return "프로그램 오류가 발생하였습니다.";
    }
}
