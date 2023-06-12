package com.bona.javacalculator.service;

import com.bona.javacalculator.io.Console;
import com.bona.javacalculator.model.InputAndAnswer;
import com.bona.javacalculator.repository.CalMemoryRepository;

import java.util.Optional;

public class CalculateService {
    private final AnalyzeService analyzeService = new AnalyzeService();
    private final MakePostfixService makePostfixService = new MakePostfixService();
    private  final ValidateService validateService = new ValidateService();
    private final CalMemoryRepository calMemoryRepo = new CalMemoryRepository();
    private final Console console = new Console();

    public void calculate() {
        String input = console.input("식을 입력해주세요 : ");
        Optional<String> validateInput = checkValidate(input);
        if (validateInput.isEmpty()) {
            return;
        }
        String postfix = makePostfixService.convPostfix(validateInput.get());
//        System.out.println("postfix = " + postfix);
        Double result = analyzeService.analyzeStr(postfix);
        calMemoryRepo.save(new InputAndAnswer(input, result));

        console.outAnswer(result);
    }
    private Optional<String> checkValidate(String input) {
        Optional<String> testInput = validateService.validate(input);
        if (testInput.isEmpty()) {
            console.inputError();
            return Optional.empty();
        }
        return testInput;
    }
}
