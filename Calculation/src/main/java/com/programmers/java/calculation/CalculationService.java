package com.programmers.java.calculation;

import com.programmers.java.calculation.calculate.Calculate;
import com.programmers.java.calculation.io.Input;
import com.programmers.java.calculation.io.Output;
import com.programmers.java.calculation.parse.Parsing;
import com.programmers.java.calculation.parse.Validation;
import com.programmers.java.calculation.repository.Repository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CalculationService implements Runnable {

    private final Input input;
    private final Output output;
    private final Repository repository;
    private final Validation validation;
    private final Parsing parsing;
    private final Calculate calculate;

    @Override
    public void run() {

        while (true) {
            String inputString = input.input("1. 조회 \n2. 계산 \n3. 종료");

            if (inputString.equals("3")) {
                System.out.println("종료");
                break;
            } else if (inputString.equals("1")) {
                System.out.println("조회 선택");
                repository.printAll();
            } else if (inputString.equals("2")) {
                System.out.println("계산 선택");
                String inputForCal = input.input("식을 입력해주세요.");

                Optional<Double> resultOutput = getOutput(inputForCal);
                if (resultOutput.isEmpty()) {
                    output.wrongInput();
                    continue;
                }
                saveOutput(resultOutput.get(), getFrontOfOutput(inputForCal));

            } else {
                output.wrongInput();
            }

        }

    }

    protected Optional<Double> getOutput(String inputForCal) {
        String inputRemoveSpase = parsing.removeSpase(inputForCal);

        if (inputRemoveSpase.equals("") || !validation.validationTotal(inputRemoveSpase)) {
            output.wrongInput();
            return Optional.empty();
        }

        List<String> resultList = parsing.makeArray(inputRemoveSpase);
        Optional<Double> output = calculate.fourRules(resultList);
        return output;
    }

    private void saveOutput(Double result, StringBuilder saveInput) {
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

    private StringBuilder getFrontOfOutput(String inputForCal) {
        List<String> list = parsing.makeArray(parsing.removeSpase(inputForCal));
        StringBuilder frontOfOutput = new StringBuilder();
        for (String s : list) {
            frontOfOutput.append(s + " ");
        }
        return frontOfOutput;
    }




}
