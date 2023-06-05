import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum CalculateType {
    ADD("+",1, (left, right) -> left + right),
    SUBTRACT("-",1, (left, right) -> left - right),
    MULTIPLY("*",2, (left, right) -> left * right),
    DIVIDE("/",2, (left, right) ->
    {if (right == 0) {throw new ArithmeticException("0으로 나누어선 안됩니다.");}
        return left / right;});

    //  bifunction : 첫번쨰 매개변수 타입, 두번쨰 매개변수 타입, 반환 타입
    private String symbol;
    private int priority;
    private BiFunction<Long, Long, Long> process;

    CalculateType(String symbol,int priority, BiFunction<Long, Long, Long> process) {
        this.symbol = symbol;
        this.priority = priority;
        this.process = process;
    }

    public long calculate(long left,long right){
        //apply : 제네릭 타입인 한 개의 매개변수를 전달받아 특정 작업을 수행 후 값을 반환합
        return process.apply(left,right);
    }

    public int getPriority() {
        return priority;
    }

    public String getSymbol() {
        return symbol;
    }

    public static CalculateType findBySymbol(String symbol){
        return Arrays.stream(CalculateType.values())
                .filter(calculateType -> calculateType.getSymbol().equals(symbol))
                .findFirst()
                .orElse(null);
    }
}
