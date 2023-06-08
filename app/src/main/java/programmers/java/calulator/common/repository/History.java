package programmers.java.calulator.common.repository;

public abstract class History {
    private String expression;
    private Integer result;

    protected History(String expression, Integer result) {
        this.expression = expression;
        this.result = result;
    }
    @Override
    public String toString() {
        return expression + FormatConstants.HISTORY_FORMAT_DELIMITER + result;
    }
}
