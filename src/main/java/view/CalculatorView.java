package view;

import controller.CalculatorController;
import domain.Result;
import view.utils.InputValidation;
import view.io.IO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorView {
    private IO io;
    private CalculatorController controller;
    private Map<String, Request> optionRequestMap = new HashMap();

    public CalculatorView(IO io, CalculatorController controller) {
        this.io = io;
        this.controller = controller;
        init();
    }

    private void init() {
        optionRequestMap.put("1", () -> printResults());
        optionRequestMap.put("2", () -> printResult());
    }

    public void printInit() {
        printOptions();
        String choice = getChoice();

        try {
            InputValidation.checkOption(choice);
            optionRequestMap.get(choice).process();
        } catch (IllegalArgumentException e) {
            io.print(e.getMessage() + "\n");
        }
    }

    private void printResults() {
        List<Result> results = controller.results();
        io.print("\n");
        for (Result result : results) {
            io.print(result.getProblem() + " = " + result.getAnswer() + "\n");
        }
        io.print("\n");
    }

    private void printResult() {
        io.print("\n");
        String problem = io.read();

        try {
            InputValidation.checkMathExpression(problem);
            Result result = controller.calculate(problem);
            io.print(result.getAnswer() + "\n\n");
        } catch (IllegalArgumentException e) {
            io.print(e.getMessage() + "\n");
        }
    }
    private void printOptions() {
        io.print("1. 조회\n2. 계산\n\n");
    }

    private String getChoice() {
        io.print("선택 : ");
        return io.read();
    }

}