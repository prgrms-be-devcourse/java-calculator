package controller;

import calculator.StringCalculator;
import consoleview.ConsoleView;
import database.Database;
import database.FormulaEntity;

import java.io.IOException;

public class CalculatorController {
    ConsoleView consoleView;
    StringCalculator stringCalculator;
    Database db;

    public CalculatorController() {
        this.consoleView = new ConsoleView();
        this.stringCalculator = new StringCalculator();
        this.db = new Database();
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
        db.add(userInput, result);
        consoleView.display(Double.toString(result));
        consoleView.displayBlankLine();
        consoleView.displayBlankLine();
    }

    public void getHistory() {
        consoleView.displayBlankLine();
        FormulaEntity[] results = db.findAll();
        for (FormulaEntity prevFormula:results){
            consoleView.display(prevFormula.toString());
        }
        consoleView.displayBlankLine();
    }

    public void run() {
        while (true) {
            try {
                int selectedNumber = Integer.parseInt(this.displayAndGetUserInput());
                if (selectedNumber == 3) {
                    consoleView.displayCloseMessage();
                    consoleView.close();
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
