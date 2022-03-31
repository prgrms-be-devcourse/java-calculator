package hyuk.entity;

import hyuk.calculator.Result;

public class Record {

    private static long SEQUENCE = 0;
    private Long id;
    private String formula;
    private Integer result;

    private Record() {
    }

    public static Record createLog(String formula, Result result) {
        Record log = new Record();
        log.id = ++SEQUENCE;
        log.formula = formula;
        log.result = result.showResult();
        return log;
    }

    public Long getId() {
        return id;
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
