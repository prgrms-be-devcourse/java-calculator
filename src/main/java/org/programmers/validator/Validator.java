package org.programmers.validator;


import java.util.ArrayList;
import java.util.List;

public class Validator {
    private static final String NUMBER_PATTERN = "[0-9]+";
    private static final String OPERATOR_PATTERN = "[*+/-]";


    // 연산식 검증 로직
    public boolean validateCalculation(String inputMsg) {
        List<String> formulaList = validateFormulaSplit(inputMsg);

        if (formulaList.isEmpty()) {
            console.printError("잘못된 입력값입니다.");
            return false;
        }

        boolean afterCheck = validateFormula(formulaList);

        if (!afterCheck) {
            System.out.println("잘못된 입력값입니다");
        }

        return afterCheck;
    }


    // 연산식 검증: 연산식 분해 후 하나씩 검증
    public List<String> validateFormulaSplit(String inputMsg) {
        String[] splitMsg = inputMsg.split(" ");
        List<String> formulaList = new ArrayList<>();

        for (String str : splitMsg) {
            if (str.matches(NUMBER_PATTERN) || str.matches(OPERATOR_PATTERN)) {
                formulaList.add(str);
            } else {
                return new ArrayList<>();
            }
        }

        return formulaList;
    }

    public boolean validateFormula(List<String> formulaList) {
        if (formulaList.size() % 2 == 0) {
            return false;
        }

        for (int i = 0; i < formulaList.size(); i++) {
            if (i % 2 == 0 && !formulaList.get(i).matches(NUMBER_PATTERN)) {
                return false;
            }
            if (i % 2 == 1 && !formulaList.get(i).matches(OPERATOR_PATTERN)) {
                return false;
            }
        }

        return true;
    }
}