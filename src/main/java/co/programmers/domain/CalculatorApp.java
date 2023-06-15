package co.programmers.domain;

import static co.programmers.domain.UserMenu.CALCULATE;
import static co.programmers.domain.UserMenu.INQUIRY;
import static co.programmers.domain.UserMenu.TERMINATE;

import co.programmers.view.CalculatorInputView;
import co.programmers.view.CalculatorOutputView;
import co.programmers.view.InputView;
import co.programmers.view.OutputView;
import java.util.HashMap;
import java.util.Map;

public class CalculatorApp {

    private final Map<Integer, Runnable> menuToCommandMapper = new HashMap<>();
    private InputView inputView;
    private OutputView outputView;

    private CalculatorApp() {
        menuToCommandMapper.put(INQUIRY.getMenu(), this::executeInquiryMenu);
        menuToCommandMapper.put(CALCULATE.getMenu(), this::executeCalculationMenu);
        menuToCommandMapper.put(TERMINATE.getMenu(), () -> {
        });
    }

    public CalculatorApp(InputView inputView, OutputView outputView) {
        this();
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static void main(String[] args) {
        InputView inputView = new CalculatorInputView();
        OutputView outputView = new CalculatorOutputView();
        CalculatorApp calculatorApp = new CalculatorApp(inputView, outputView);
        try {
            calculatorApp.run();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    public void run() {
        UserMenu userMenu;
        do {
            userMenu = UserMenu.get(inputView.inputUserMenu());
            Runnable command = menuToCommandMapper.get(userMenu.getMenu());
            command.run();
        } while (userMenu != TERMINATE);
    }

    public void executeInquiryMenu() {
        //TODO
    }

    public void executeCalculationMenu() {
        try {
            Expression expression = inputView.inputExpression();
            Calculator calculator = new Calculator(" ", expression.getExpression());
            Integer output = calculator.calculate();
            outputView.printCalculationRes(output);
        } catch (ArithmeticException | IllegalArgumentException arithmeticException) {
            System.out.println(arithmeticException.getMessage());
        }
    }
}
