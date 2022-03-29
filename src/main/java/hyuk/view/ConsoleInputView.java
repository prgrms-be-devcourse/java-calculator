package hyuk.view;

import java.util.Scanner;

public class ConsoleInputView implements InputView {

    private static final String MENU_ERROR_MSG = "1 또는 2를 입력해주세요.";
    private static final String FORMULA_ERROR_MSG = "정규 표현식이 아닙니다.";

    public String selectMenu(Scanner scanner) {
        String menu = scanner.next();

        if (menu.equals("1") || menu.equals("2")) {
            return menu;
        }
        throw new IllegalStateException(MENU_ERROR_MSG);
    }

    public String inputFormula(Scanner scanner) {
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
            if (i % 2 == 0) {
                if (!isOperand(tokens[i])) {
                    throw new IllegalStateException(FORMULA_ERROR_MSG);
                }
                continue;
            }
            if (!isOperator(tokens[i])) {
                throw new IllegalStateException(FORMULA_ERROR_MSG);
            }
        }
    }

    private boolean isOperator(String token) {
        return token.matches("[+\\-*/]");
    }

    private boolean isOperand(String token) {
        return token.matches("^[0-9]*$");
    }


}
