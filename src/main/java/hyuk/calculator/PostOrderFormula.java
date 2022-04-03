package hyuk.calculator;

import hyuk.util.PatternValidator;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostOrderFormula {

    public static final String SPACE = " ";
    private List<String> postOrderFormula;

    public PostOrderFormula(String formula) {
        this.postOrderFormula = translateToPostOrderFormula(formula);
    }

    private List<String> translateToPostOrderFormula(String formula) {
        Deque<String> stack = new ArrayDeque<>();
        List<String> postOrderFormula = new ArrayList<>();

        String[] tokens = formula.split(SPACE);
        for (String token : tokens) {
            translate(stack, postOrderFormula, token);
        }

        while (!stack.isEmpty()) {
            postOrderFormula.add(stack.pollLast());
        }
        return postOrderFormula;
    }

    private void translate(Deque<String> stack, List<String> postOrderFormula, String token) {
        if (isOperand(token)) {
            postOrderFormula.add(token);
            return;
        }
        putOperator(postOrderFormula, stack, token);
    }

    private void putOperator(List<String> postOrderFormula, Deque<String> stack, String token) {
        while (!stack.isEmpty() && !checkPriority(token, stack.getLast())) {
            postOrderFormula.add(stack.pollLast());
        }
        stack.addLast(token);
    }

    private boolean checkPriority(String pushOperator, String topOperator) {
        return (pushOperator.equals("*") || pushOperator.equals("/")) && (topOperator.equals("+")
            || topOperator.equals("-"));
    }

    private boolean isOperand(String token) {
        return PatternValidator.OperandPattern.matcher(token).matches();
    }

    public List<String> getPostOrderFormula() {
        return postOrderFormula;
    }
}
