package hyuk;

import java.util.ArrayList;
import java.util.List;

public class Operators {

    private final char[] OPERATOR_ARR = {'+', '-', '*', '/'};
    private List<Character> operators;

    public Operators(String exp) {
        operators = new ArrayList<>();

        String tokens[] = exp.split("");
        for (String token : tokens) {
            if (isOperator(token)) {
                operators.add(token.charAt(0));
            }
        }
    }

    private boolean isOperator(String token) {
        if (token.length() > 1) {
            return false;
        }

        for (char OPERATOR : OPERATOR_ARR) {
            if (token.charAt(0) == OPERATOR) {
                return true;
            }
        }
        return false;
    }

    public List<Character> getOperators() {
        return operators;
    }
}
