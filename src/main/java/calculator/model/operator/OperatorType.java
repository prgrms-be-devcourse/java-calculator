package calculator.model.operator;

public enum OperatorType {
    OPENED_BRACKET("(",0),
    CLOSED_BRACKET(")",0),
    TIMES("*",1),
    DIVIDER("/",1),
    PLUS("+",2),
    MINUS("-",2);

    private final int priority;
    private final String symbol;

    OperatorType(String symbol, int priority){
        this.symbol = symbol;
        this.priority = priority;
    }

    public String getSymbol(){
        return symbol;
    }

    public int getPriority(){
        return priority;
    }

    public boolean hasLowerPriority(OperatorType other) { // priority 값이 비교 대상보다 크거나 같아야 우선순위가 낮다.
        return this.priority >= other.priority;
    }
}
