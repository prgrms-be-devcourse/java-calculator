package com.programmers.validator;

public class Validator {
    private final String operators = "+-*/()";
    private final String pattern = "[0-9\\s]+";

    // 입력이 1+2 가 아닌 1 + 2와 같이 공백이 포함되어 들어오더라도
    // 처리할 수 있도록 converter를 만들어볼까?

    public boolean checkFormula(String formula) {
        String result = formula.replaceAll(pattern, "");
        for (int i = 0; i < result.length(); i++) {
            if (!isOperator(String.valueOf(result.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public boolean isOperator(String o) {
        return operators.contains(o);
    }

}
