package Domain.Expression;

public class SolvedExpression {
    private String exp;
    private Double result;

    public SolvedExpression(String exp, Double result) {
        this.exp = exp;
        this.result = result;
    }

    public String getExp() {
        return exp;
    }

    public Double getResult() {
        return result;
    }
}
