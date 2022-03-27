package controller;

import calculator.StringCalculator;
import consoleview.ConsoleView;

import java.io.IOException;

public class CalculatorController {
    ConsoleView consoleView;
    StringCalculator stringCalculator;

    public CalculatorController() {
        this.consoleView = new ConsoleView();
        this.stringCalculator = new StringCalculator();
    }

    public String displayAndGetUserInput() throws IOException {
        consoleView.display();
        String userInput = consoleView.getUserInput();
        return userInput;
    }

    public void calculate() throws Exception {
        consoleView.displayCalculator();

        String userInput = consoleView.getUserInput();
        double result = this.stringCalculator.calculate(userInput);

        consoleView.display(Double.toString(result));
        consoleView.displayBlankLine();
        consoleView.displayBlankLine();
    }

    public void getHistory() {
    }

    public void run() {
        while (true) {
            try {
                int selectedNumber = Integer.parseInt(this.displayAndGetUserInput());
                if (selectedNumber == 3) {
                    this.consoleView.close();
                    break;
                }
                assignUserInput(selectedNumber);
            } catch (Exception e) {
                consoleView.displayErrorMessage();
            }
        }
    }

    private void assignUserInput(int selectedNumber) throws Exception {
        if (selectedNumber == 1) this.getHistory();
        else this.calculate();
    }
}
