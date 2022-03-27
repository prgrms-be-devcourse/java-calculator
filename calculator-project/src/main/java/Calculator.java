import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class Calculator<T extends Number> implements ICalculator<T> {
    private Integer TEST_VALUE = 1;
    private IHistory history;

    public T calculate(String operation) {
        // 검증된 operation 을 계산한다

        return (T) TEST_VALUE;
    }

    boolean isOperator(char o) {
        if (o == '+' || o == '-' || o == '*' || o == '/') return true;
        return false;
    }

    List<String> getHistory(){
        return history.getList();
    }
}
