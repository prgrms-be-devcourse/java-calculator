package com.programmers.java.calculation;

import com.programmers.java.calculation.calculate.CalculateBasicImpl;
import com.programmers.java.calculation.io.Input;
import com.programmers.java.calculation.io.Output;
import com.programmers.java.calculation.parse.Parsing;
import com.programmers.java.calculation.parse.ParsingImpl;
import com.programmers.java.calculation.parse.ValidationAddDecimalImpl;
import com.programmers.java.calculation.repository.Repository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CalculationService implements Runnable {

    private final Input input;
    private final Output output;
    private final Repository repository;
    private final Parsing parsing;
    private final Calculation calculation;

    @Override
    public void run() {

        while (true) {
            String inputString = input.input("1. 조회 \n2. 계산");

            if (inputString.equals("1")) {
                System.out.println("조회 선택");
                repository.findAll();
            } else if (inputString.equals("2")) {
                System.out.println("계산 선택");
                String inputForCal = input.input("식을 입력해주세요.");
                if (inputForCal.replaceAll(" ", "").equals("")) {
                    output.wrongInput();
                    continue;
                }

                Double result = calculation.calculationAndValidate(inputForCal);
                if (result == null) {
                    output.wrongInput();
                } else {
                    StringBuilder saveInput = getSaveInput(inputForCal);
                    removeDot(result, saveInput);
                }
            } else {
                output.wrongInput();
            }

        }

    }

    private void removeDot(Double result, StringBuilder saveInput) {
        int i = result.intValue();
        if (i == result) {
            output.correct(i);
            repository.save(saveInput + "= " + i);
        } else {
            String format = String.format("%.2f", result);
            output.correct(format);
            repository.save(saveInput + "= " + format);
        }
    }

    private StringBuilder getSaveInput(String inputForCal) {
        List<String> list = parsing.makeArray(parsing.removeSpase(inputForCal));
        StringBuilder saveInput = new StringBuilder();
        for (String s : list) {
            saveInput.append(s + " ");
        }
        return saveInput;
    }


}
