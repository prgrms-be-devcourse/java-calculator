package calculator.engine.model;

public class OperatorOrder {

    private char sign;
    private int idx;

    public OperatorOrder(char operator, int idx) {
        this.sign = operator;
        this.idx = idx;
    }

    public char getSign() {
        return sign;
    }

    public int getIdx() {
        return idx;
    }
}
