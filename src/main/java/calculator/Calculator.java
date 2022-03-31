package calculator;

import java.text.DecimalFormat;

import calculator.domain.MenuType;
import calculator.domain.PostfixExpression;
import calculator.repository.ResultRepository;
import calculator.utils.PostfixParser;
import calculator.view.Console;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator implements Runnable {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    private final ResultRepository repository;
    private final InputView inputView;
    private final OutputView outputView;

    public Calculator(ResultRepository repository, Console console) {
        this.repository = repository;
        this.inputView = console;
        this.outputView = console;
    }

    @Override
    public void run() {
        boolean isNotEndProgram = true;

        while (isNotEndProgram) {
            String command = inputView.inputMenu();

            switch (MenuType.from(command)) {
                case MENU_RECORD:
                    outputView.printResults(repository.findAll());
                    break;
                case MENU_CALCULATE:
                    calculateExpression();
                    break;
                case END_PROGRAM:
                    isNotEndProgram = false;
                    break;
                default:
                    outputView.printWrongCommandError();
            }
        }
    }

    private void calculateExpression() {
        boolean wrongInput = true;
        while (wrongInput) {
            String expression = inputView.inputExpression();
            wrongInput = calculate(expression);
        }
    }

    private boolean calculate(String expression) {
        try {
            PostfixExpression postfix = new PostfixExpression(PostfixParser.parse(expression));
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
