package com.programmers.java.io;

import com.programmers.java.exception.FormulaInputException;
import com.programmers.java.exception.MenuInputNotNumberException;

public interface Input {
    int inputMenuNumber() throws MenuInputNotNumberException;

    String inputFormula() throws FormulaInputException;
}
