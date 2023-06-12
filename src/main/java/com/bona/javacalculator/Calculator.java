package com.bona.javacalculator;

import com.bona.javacalculator.io.Console;

import com.bona.javacalculator.model.InputAndAnswer;
import com.bona.javacalculator.repository.CalMemoryRepository;
import com.bona.javacalculator.service.CalService;
import com.bona.javacalculator.service.Check;
import com.bona.javacalculator.service.ValidateService;

import java.util.List;
import java.util.Optional;

public class Calculator implements Runnable{

    private static final CalService calService = new CalService();
    private static final ValidateService validateService = new ValidateService();
    private static final CalMemoryRepository calMemoryRepo = new CalMemoryRepository();
    private final Console console = new Console();
    @Override
    public void run() {
        boolean isRun = true;

        while(isRun){
            String input = console.input("1. 조회 2. 계산");
            int number = parse(input);
            Option option = Option.valueOf(number);

            if (option == null) {
                continue;
            }

            switch (option) {
                case INQUIRY:
                    inquiry();
                    break;
                case CALCULATE:
                    calculate();
                    break;
                case EXIT:
                    isRun = false;
                    break;
                default:
                    break;
            }

        }
    }

    private void calculate() {
        String input = console.input("식을 입력해주세요 : ");
        Optional<String> validateInput = checkValidate(input);
        if (validateInput.isEmpty()) {
            return;
        }
        String postfix = calService.convPostfix(validateInput.get());
//        System.out.println("postfix = " + postfix);
        Double result = calService.calculateStr(postfix);
        calMemoryRepo.save(new InputAndAnswer(input, result));

        console.outAnswer(result);
    }

    private void inquiry() {
        List<InputAndAnswer> all = calMemoryRepo.findAll();
        if (all.isEmpty()) {
            console.printMessage("조회 결과 기록이 존재하지 않습니다");
            return;
        }
        console.printAll(all);

    }

    private Optional<String> checkValidate(String input) {
        Optional<String> testInput = validateService.validate(input);
        if (testInput.isEmpty()) {
            console.inputError();
            return Optional.empty();
        }
        return testInput;
    }

    private int parse(String input) {
        return Integer.parseInt(input);
    }

}
