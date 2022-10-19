package com.programmers.java.validator;

import java.util.List;

public interface Validator {

    void validateFormula(String formula);

    void validateNull(String formula);

    void validateLength(List<String> formulaList);

    void validateOrder(List<String> formulaList);

    void validateDivideZero(List<String> formulaList);

}
