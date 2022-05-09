package calculator.model.expression;

public abstract class ExpressionableToken {
    private final String value;
    protected ExpressionableToken(String value){
        this.value = value;
    }

    public abstract boolean couldOtherTokenComeNext(ExpressionableToken other);

    public String getValue() {
        return value;
    }
}
