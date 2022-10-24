package com.programmers.java.io;

import com.programmers.java.exception.FormulaInputException;
import com.programmers.java.exception.MenuInputException;

public interface Input {
    String inputMenuNumber() throws MenuInputException;

    String inputFormula() throws FormulaInputException;
}
