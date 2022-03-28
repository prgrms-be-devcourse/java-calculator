package hyuk.entity;

import hyuk.calculator.Result;

public class Log {

    private static long SEQUENCE = 0;
    private Long id;
    private String formula;
    private Integer result;

    private Log() {
    }

    public static Log createLog(String formula, Result result) {
        Log log = new Log();
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
