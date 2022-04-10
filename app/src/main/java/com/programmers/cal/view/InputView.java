package com.programmers.cal.view;

import com.programmers.cal.error.ErrorMessage;

import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final Pattern PATTERN = Pattern.compile(".*\\d$");
    private static final String INVALID_DIVISION_ZERO = " / 0";

    private static final Scanner SC = new Scanner(System.in);

    public static InputMenu selectTheMenu() {
        Optional<InputMenu> menu = InputMenu.findOf(SC.nextLine());
        validatedTheMenu(menu);

        return menu.get();
    }

    public static String inputTheFormula() {
        String formula = SC.nextLine();
        validatedTheFormula(formula);

        return formula;
    }

    private static void validatedTheMenu(Optional<InputMenu> menu) {
        if (menu.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.MENU_ERROR_MESSAGE.getMessage());
        }
    }

    private static void validatedTheFormula(String formula) {
        if (!PATTERN.matcher(formula).matches() && !formula.contains(INVALID_DIVISION_ZERO)) {
            throw new IllegalArgumentException(ErrorMessage.FORMULA_ERROR_MESSAGE.getMessage());
        }
    }

}
