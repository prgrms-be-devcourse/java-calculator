package com.programmers.java.io;

import com.programmers.java.exception.FormulaInputException;
import com.programmers.java.exception.MenuInputNotNumberException;

public interface Validate {
    int menuInputIsNumberValidate(String chosenNumber) throws MenuInputNotNumberException;

    String formulaValidate(String formula) throws FormulaInputException;

    boolean isNumber(String token);

    boolean isOperator(String token);

    boolean isOpenBracket(String token);

    boolean isCloseBracket(String token);
}
