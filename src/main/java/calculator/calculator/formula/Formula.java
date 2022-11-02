package calculator.calculator.formula;

import java.util.List;

public class Formula {

    private final List<String> formula;

    public Formula(List<String> formula) {
        this.formula = formula;
    }

    public List<String> getFormula() {
        return formula;
    }

    public void add(String formulaPiece) {
        formula.add(formulaPiece);
    }

    public void clear() {
        formula.clear();
    }
}
