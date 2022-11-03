package calculator.calculator.formula;

import java.util.List;
import java.util.stream.Collectors;

public class Formula {

    private final List<String> formula;

    public Formula(List<String> formula) {
        this.formula = formula;
    }

    public List<String> getFormulaPieces() {
        return formula;
    }

    public String getFormulaWithNoSpace() {
        return formula.stream()
                .filter(formulaPiece -> !formulaPiece.isEmpty())
                .collect(Collectors.joining());
    }

    public Formula clone() {
        return new Formula(formula);
    }

    public void add(String formulaPiece) {
        formula.add(formulaPiece);
    }

    public void clear() {
        formula.clear();
    }
}
