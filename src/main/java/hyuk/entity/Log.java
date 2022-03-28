package hyuk.entity;

import hyuk.model.Operands;
import hyuk.model.Operators;
import hyuk.model.Result;

public class Log {

    private static long SEQUENCE = 0;
    private Long id;
    private String formula;
    private Integer result;

    private Log() {
    }

    public static Log createLog(Operands operands, Operators operators, Result result) {
        Log log = new Log();
        log.id = ++SEQUENCE;
        log.formula = makeFormula(operands, operators);
        log.result = result.showResult();
        return log;
    }

    private static String makeFormula(Operands operands, Operators operators) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < operands.getOperands().size(); ++i) {
            sb.append(operands.getOperands().get(i) + " ");
            if (i < operators.getOperators().size()) {
                sb.append(operators.getOperators().get(i) + " ");
            }
        }
        return sb.substring(0, sb.length() - 1); //마지막 공백 제거용 위해 -1
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
        return formula + " = " + String.valueOf(result);
    }
}
