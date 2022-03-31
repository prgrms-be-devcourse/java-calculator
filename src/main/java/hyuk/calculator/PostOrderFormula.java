package hyuk.calculator;

import hyuk.util.PatternValidator;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostOrderFormula {

    private List<String> postOrderFormula;

    public PostOrderFormula(String formula) {
        this.postOrderFormula = translateToPostOrderFormula(formula);
    }

    private List<String> translateToPostOrderFormula(String formula) {
        Deque<String> stack = new ArrayDeque<>();
        List<String> postOrderFormula = new ArrayList<>();

        String[] tokens = formula.split(" ");
        for (String token : tokens) {
            if (isOperand(token)) {
                postOrderFormula.add(token);
                continue;
            }
            putOperator(postOrderFormula, stack, token);
        }

        while (!stack.isEmpty()) {
            postOrderFormula.add(stack.pollLast());
        }
        return postOrderFormula;
    }

    private void putOperator(List<String> postOrderFormula, Deque<String> stack, String token) {
        while (!stack.isEmpty()) {
            if (checkPriority(token, stack.getLast())) {
                break;
            }
            postOrderFormula.add(stack.pollLast());
        }
        stack.addLast(token);
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

    public List<String> getPostOrderFormula() {
        return postOrderFormula;
    }
}
