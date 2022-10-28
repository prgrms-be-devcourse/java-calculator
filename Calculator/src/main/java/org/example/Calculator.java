package org.example;

import org.example.compute.Compute;
import org.example.compute.ComputeManager;
import org.example.io.Input;
import org.example.io.Output;
import org.example.repository.Repository;
import org.example.validate.Validate;

import java.io.IOException;

public class Calculator {
    private Input input;
    private Output output;
    private Validate validate;
    private Compute compute;
    private Repository repository;


    public Calculator(Input input, Output output, Validate validate, Compute compute, Repository repository) {
        this.input = input;
        this.output = output;
        this.validate = validate;
        this.compute = compute;
        this.repository = repository;
    }

    public void run() throws IOException {
        ComputeManager computeManager = new ComputeManager(true);
        while(computeManager.getState()){
            printMenu();
            String input = getInput();
            if(!validateInput(input)) continue;
            Menu selectedMenu = selectMenu(input);
            runByMenu(computeManager,selectedMenu);
        }
    }

    private void printMenu() {
        output.printMenu("1. 조회\n2. 계산\n3. 종료");
    }
    private String getInput() throws IOException {
        return input.selectMenu("선택 : ");
    }
    private boolean validateInput(String input) {
        return validate.isValidExpression(input);
    }
    private Menu selectMenu(String input) {
        int menuNumber = Integer.parseInt(input);
        return Menu.getMenu(menuNumber);
    }
    private void runByMenu(ComputeManager computeManager, Menu selectedMenu) throws IOException {
        switch (selectedMenu) {
            case HISTORY:
                output.printSavedResults(repository);
                break;
            case CALCULATE:
                String expression = input.input();

                if(!validate.isValidExpression(expression)) return;

                long answer = compute.compute(expression);

                repository.saveResult(expression, answer);

                output.printCalculatedResult(answer);
                break;
            case EXIT:
                computeManager.setState(false);
                break;
        }
    }
}
