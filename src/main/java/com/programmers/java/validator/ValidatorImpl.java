package com.programmers.java.validator;

import com.programmers.java.tokenizer.Tokenizer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.programmers.java.enums.ErrorMessage.*;

@Getter @Setter
public class ValidatorImpl implements Validator {

    private final String regex = "[-]?\\d*(\\.\\d+)?";
    private final String operators = "+*-/";
    private final Tokenizer tokenizer;

    public ValidatorImpl(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    @Override
    public void validateFormula(String formula) {
        validateNull(formula);

        List<String> formulaList = tokenizer.tokenizeFormula(formula);
        validateLength(formulaList);
        validateOrder(formulaList);
        validateDivideZero(formulaList);
    }

    @Override
    public void validateNull(String formula) {
        if (formula.isBlank()) {
            throw new NullPointerException(EMPTY_INPUT.getMessage());
        }
    }

    @Override
    public void validateLength(List<String> formulaList) {
        if (formulaList.size() == 1 || formulaList.size() % 2 == 0) {
            throw new IllegalArgumentException(INVALID_FORMULA.getMessage());
        }
    }

    @Override
    public void validateOrder(List<String> formulaList) {
        for (int i = 0; i < formulaList.size(); i++) {

            if (i % 2 == 0) {
                if (formulaList.get(i).equals("-") || !formulaList.get(i).matches(regex)) {
                    throw new IllegalArgumentException(INVALID_OPERAND.getMessage());
                }
            } else {
                if (!operators.contains(formulaList.get(i))) {
                    throw new IllegalArgumentException(INVALID_OPERATOR.getMessage());
                }
            }
        }
    }

    @Override
    public void validateDivideZero(List<String> formulaList) {
        for (int i = 0; i < formulaList.size() - 1; i++) {

            if (formulaList.get(i).charAt(0) == '/' && formulaList.get(i + 1).charAt(0) == '0') {
                throw new IllegalArgumentException(NOT_DIVIDE_ZERO.getMessage());
            }
        }
    }
}
