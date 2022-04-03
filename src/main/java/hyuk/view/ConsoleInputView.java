package hyuk.view;

import hyuk.util.PatternValidator;
import java.util.Scanner;

public class ConsoleInputView implements InputView {

    private static final String MENU_ERROR_MSG = "1 또는 2를 입력해주세요.";
    private static final String FORMULA_ERROR_MSG = "정규 표현식이 아닙니다.";
    private static final String PRINT = "1";
    private static final String CALCULATE = "2";

    private final Scanner scanner;

    public ConsoleInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String selectMenu() {
        String menu = scanner.nextLine();

        if (menu.equals(PRINT) || menu.equals(CALCULATE)) {
            return menu;
        }
        throw new IllegalStateException(MENU_ERROR_MSG);
    }

    public String inputFormula() {
        String formula = scanner.nextLine();

        validateRegex(formula);
        return formula;
    }

    private void validateRegex(String formula) {
        String[] tokens = formula.split(" ");
        if (tokens.length % 2 == 0) {
            throw new IllegalStateException(FORMULA_ERROR_MSG);
        }

        for (int i = 0; i < tokens.length; ++i) {
            validate(tokens, i);
        }
    }

    private void validate(String[] tokens, int i) {
        if (i % 2 == 0) {
            validateOperand(tokens, i);
            return;
        }
        validateOperator(tokens, i);
    }

    private void validateOperator(String[] tokens, int i) {
        if (!isOperator(tokens[i])) {
            throw new IllegalStateException(FORMULA_ERROR_MSG);
        }
    }

    private void validateOperand(String[] tokens, int i) {
        if (!isOperand(tokens[i])) {
            throw new IllegalStateException(FORMULA_ERROR_MSG);
        }
    }

    private boolean isOperator(String token) {
        return PatternValidator.OperatorPatter.matcher(token).matches();
    }

    private boolean isOperand(String token) {
        return PatternValidator.OperandPattern.matcher(token).matches();
    }

}
