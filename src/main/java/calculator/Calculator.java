package calculator;

import java.text.DecimalFormat;

import calculator.domain.PostfixExpression;
import calculator.repository.ResultRepository;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator implements Runnable {
    private static final String END_PROGRAM = "3";
    private static final String MENU_RECORD = "1";
    private static final String MENU_CALCULATE = "2";
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
            if (command.equals(END_PROGRAM)) {
                break;
            }

            if (command.equals(MENU_RECORD)) {
                repository.findAll()
                    .ifPresentOrElse(outputView::printResults, outputView::printNoResults);
                continue;
            }

            if (command.equals(MENU_CALCULATE)) {
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
            String result = DECIMAL_FORMAT.format(postfix.calculate());
            repository.save(expression + " = " + result);
            outputView.printResult(result);
            return false;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMsg(e.getMessage());
        }
        return true;
    }
}
