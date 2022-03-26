package calculator;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Stack;

import calculator.domain.OperatorType;
import calculator.repository.ResultRepository;
import calculator.utils.ExpressionParser;
import calculator.utils.Parser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator implements Runnable {
    private static final String ERROR_INPUT_FORM = "[ERROR] 정상적인 입력이 아닙니다. 다시 입력해주세요.";
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    private final ResultRepository repository;
    private final Parser parser;
    private final InputView inputView;
    private final OutputView outputView;

    public Calculator(ResultRepository repository, Parser parser, InputView inputView, OutputView outputView) {
        this.repository = repository;
        this.parser = parser;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void run() {
        while (true) {
            String command = inputView.inputMenu();
            if (command.equals("3")) {
                break;
            }

            if (command.equals("1")) {
                repository.findAll()
                    .ifPresentOrElse(outputView::printResults, outputView::printNoResults);
                continue;
            }

            if (command.equals("2")) {
                boolean wrongInput = true;
                while (wrongInput) {
                    String expression = inputView.inputExpression();
                    wrongInput = calculateExpression(expression);
                }
                continue;
            }

            outputView.printWrongCommandError();
        }
    }

    private boolean calculateExpression(String expression) {
        try {
            List<String> postfix = parser.parsePostfix(expression);
            double result = calculate(postfix);
            repository.save(expression + " = " + DECIMAL_FORMAT.format(result));
            outputView.printResult(DECIMAL_FORMAT.format(result));
            return false;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMsg(e.getMessage());
        }
        return true;
    }

    public Double calculate(List<String> expression) {
        Stack<Double> stack = new Stack<>();

        for (String value : expression) {
            if (isNumber(value)) {
                stack.add(Double.valueOf(value));
                continue;
            }

            if (isOperator(value)) {
                validateStackPop(stack);

                double secondNumber = stack.pop();
                double firstNumber = stack.pop();
                stack.add(OperatorType.calculate(value, firstNumber, secondNumber));
            }
        }

        validateStackSize(stack);

        return stack.pop();
    }

    private void validateStackSize(Stack<Double> stack) {
        if (stack.size() > 1) {
            throw new IllegalArgumentException(ERROR_INPUT_FORM);
        }
    }

    private void validateStackPop(Stack<Double> stack) {
        if (stack.isEmpty() || stack.size() < 2) {
            throw new IllegalArgumentException(ERROR_INPUT_FORM);
        }
    }

    private boolean isOperator(String inputString) {
        return ExpressionParser.OPERATOR.matcher(inputString)
            .matches();
    }

    private boolean isNumber(String inputString) {
        return ExpressionParser.NUMBER.matcher(inputString)
            .matches();
    }
}
