package hyuk.entity;

import hyuk.calculator.Result;

public class Record {

    private Long id;
    private String formula;
    private Integer result;

    private Record() {
    }

    public static Record createRecord(String formula, Result result) {
        Record record = new Record();
        record.formula = formula;
        record.result = result.showResult();
        return record;
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
