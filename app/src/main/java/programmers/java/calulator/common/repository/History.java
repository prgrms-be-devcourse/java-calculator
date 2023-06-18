package programmers.java.calulator.common.repository;

public abstract class History {
    private final String expression;
    private final Integer result;
    public static final String HISTORY_FORMAT_DELIMITER = " = ";

    protected History(String expression, Integer result) {
        this.expression = expression;
        this.result = result;
    }

    public String getExpression() {
        return this.expression;
    }

    public Integer getResult() {
        return this.result;
    }
}
