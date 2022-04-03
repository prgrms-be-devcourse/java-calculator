package hyuk.entity;

import hyuk.calculator.Result;

public class Record {

    private Long id;
    private String formula;
    private Integer result;

    public Record(String formula, Result result) {
        this.formula = formula;
        this.result = result.showResult();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormula() {
        return formula;
    }

    public Integer getResult() {
        return result;
    }

    @Override
    public String toString() {
        return formula + " = " + result;
    }
}
