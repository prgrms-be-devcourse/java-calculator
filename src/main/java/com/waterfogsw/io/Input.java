package com.waterfogsw.io;

import com.waterfogsw.exception.InvalidFormulaInput;
import com.waterfogsw.exception.InvalidMenuInput;

import java.io.IOException;

public interface Input {
    int inputMenu(String prompt) throws IOException, InvalidMenuInput;

    String inputFormula(String prompt) throws IOException, InvalidFormulaInput;
}
