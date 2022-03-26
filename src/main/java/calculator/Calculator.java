package calculator;

import java.text.DecimalFormat;

import calculator.domain.PostfixExpression;
import calculator.repository.ResultRepository;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator implements Runnable {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    private final ResultRepository repository;
    private final InputView inputView;
    private final OutputView outputView;

    public Calculator(ResultRepository repository, InputView inputView, OutputView outputView) {
        this.repository = repository;
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
                    wrongInput = calculate(expression);
                }
                continue;
            }

            outputView.printWrongCommandError();
        }
    }

    private boolean calculate(String expression) {
        try {
            PostfixExpression postfix = PostfixExpression.from(expression);
            double result = postfix.calculate();
            repository.save(expression + " = " + DECIMAL_FORMAT.format(result));
            outputView.printResult(DECIMAL_FORMAT.format(result));
            return false;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMsg(e.getMessage());
        }
        return true;
    }
}
