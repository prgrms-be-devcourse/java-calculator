package co.programmers.application;

import co.programmers.domain.Operator;
import co.programmers.domain.UserMenu;
import co.programmers.view.CalculatorInputView;
import co.programmers.view.CalculatorOutputView;
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

    public static void main(String[] args) {
        InputView inputView = new CalculatorInputView();
        OutputView outputView = new CalculatorOutputView();
        Calculator calculator = new Calculator(inputView, outputView);
        calculator.run();
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
            if (expression[i] == ' ') {
                continue;
            }
            if (isInteger(expression[i])) {
                StringBuffer operand = new StringBuffer();
                while (i < expression.length && isInteger(expression[i])) {
                    operand.append(expression[i++]);
                }
                i--;
                Operands.push(Integer.parseInt(operand.toString()));
            } else if (expression[i] == '(') {
                Operators.push(expression[i]);
            } else if (expression[i] == ')') {
                while (Operators.peek() != '(') {
                    Operands.push(Operator.calculate(
                            String.valueOf(Operators.pop()), Operands.pop(), Operands.pop()
                    ));
                }
                Operators.pop();
            } else {
                while (!Operators.empty() && comparePriority(expression[i], Operators.peek())) {
                    Operands.push(Operator.calculate(
                            String.valueOf(Operators.pop()), Operands.pop(), Operands.pop()
                    ));
                }
                Operators.push(expression[i]);
            }
        }
        while (!Operators.empty()) {
            Operands.push(Operator.calculate(
                    String.valueOf(Operators.pop()), Operands.pop(), Operands.pop()
            ));
        }
        return Operands.pop();
    }

    private boolean comparePriority(char operator1, char operator2) {
        return Operator.getSymbol(String.valueOf(operator1)).getPriority() >
                Operator.getSymbol(String.valueOf(operator2)).getPriority();
    }

    private boolean isInteger(char c) {
        return ('0' <= c && c <= '9');
    }
}