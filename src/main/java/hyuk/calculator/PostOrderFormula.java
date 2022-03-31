package hyuk.calculator;

import hyuk.util.PatternValidator;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostOrderFormula {

    private List<String> formula;

    public PostOrderFormula(String formula) {
        Deque<String> stack = new ArrayDeque<>();
        this.formula = new ArrayList<>();

        String[] tokens = formula.split(" ");
        for (String token : tokens) {
            if (isOperand(token)) {
                this.formula.add(token);
            } else {
                while (!stack.isEmpty()) {
                    if (checkPriority(token, stack.getLast())) {
                        break;
                    }
                    this.formula.add(stack.pollLast());
                }
                stack.addLast(token);
            }
        }

        while (!stack.isEmpty()) {
            this.formula.add(stack.pollLast());
        }
    }

    private boolean checkPriority(String pushOperator, String topOperator) {
        if (pushOperator.equals("*") || pushOperator.equals("/")) {
            if (topOperator.equals("+") || topOperator.equals("-")) {
                return true;
            }
        }
        return false;
    }

    private boolean isOperand(String token) {
        return PatternValidator.OperandPattern.matcher(token).matches();
    }

    public List<String> getFormula() {
        return formula;
    }
}
