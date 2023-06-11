package co.programmers.application;

import co.programmers.domain.Operator;
import co.programmers.domain.UserMenu;
import co.programmers.view.InputView;
import co.programmers.view.OutputView;
import java.util.Stack;

public class Calculator {

    private final InputView inputView;
    private final OutputView outputView;

    public Calculator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        while (true) {
            UserMenu userMenu = UserMenu.get(inputView.inputUserMenu());
            switch (userMenu) {
                case INQUIRY:
                    // 구현 예정
                    break;
                case CALCULATE:
                    String expression = inputView.inputExpression();
                    Integer output = calculate(expression);
                    outputView.print(String.valueOf(output));
                    break;
                case TERMINATE:
                    return;
            }
        }
    }

    private Integer calculate(String input) {
        char[] expression = input.toCharArray();
        Stack<Integer> Operands = new Stack<>();
        Stack<Character> Operators = new Stack<>();
        for (int i = 0; i < expression.length; i++) {
            if (Character.isWhitespace(expression[i])) {
                continue;
            }
            if (Character.isDigit(expression[i])) {
                StringBuffer operand = new StringBuffer();
                while (i < expression.length && Character.isDigit(expression[i])) {
                    operand.append(expression[i++]);
                }
                i--;
                Operands.push(Integer.parseInt(operand.toString()));
            } else if (expression[i] == '(') {
                Operators.push(expression[i]);
            } else if (expression[i] == ')') {
                evaluateOperators(Operands, Operators);
            } else {
                while (!Operators.empty() && comparePriority(expression[i], Operators.peek())) {
                    Operands.push(Operator.calculate(
                            String.valueOf(Operators.pop()), Operands.pop(), Operands.pop()
                    ));
                }
                Operators.push(expression[i]);
            }
        }
        evaluateOperators(Operands, Operators);
        return Operands.pop();
    }

    private void evaluateOperators(Stack<Integer> operands, Stack<Character> operators) {
        while (!operators.empty() && (operators.peek() != '(')) {
            Character operator = operators.pop();
            Integer operand1 = operands.pop();
            Integer operand2 = operands.pop();
            int result = Operator.calculate(
                    String.valueOf(operator), operand1, operand2
            );
            operands.push(result);
        }

        if (!operators.empty()) {
            operators.pop();
        }
    }

    private boolean comparePriority(char operator1, char operator2) {
        return Operator.getSymbol(String.valueOf(operator1)).getPriority() >=
                Operator.getSymbol(String.valueOf(operator2)).getPriority();
    }
}