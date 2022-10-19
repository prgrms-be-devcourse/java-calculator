package com.programmers.java.service;

import java.util.List;

public interface CalculateService {

    int calculateFormula(String formula);

    List<String> convertInfixToPostFix(List<String> infixFormulaList);

}
