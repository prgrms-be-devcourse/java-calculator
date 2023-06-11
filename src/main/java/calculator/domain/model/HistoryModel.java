package calculator.domain.model;

public class HistoryModel {
    private final String formula;
    private final String answer;

    public HistoryModel(String formula,
                        String answer) {
        this.formula = formula;
        this.answer = answer;
    }

    public String getFormula() {
        return formula;
    }

    public String getAnswer() {
        return answer;
    }
}
