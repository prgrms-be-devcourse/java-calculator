package calculator;

import static calculator.view.OutputView.printWithLineBreak;
import static calculator.view.OutputView.showQuitMessage;

import calculator.controller.MainController;
import calculator.entity.InfixNotation;
import calculator.entity.Notation;
import calculator.service.Calculator;
import calculator.storage.HistoryStorage;

public class App {

    public static void main(String[] args) {
        HistoryStorage historyStorage = new HistoryStorage();
        Notation notation = new InfixNotation();
        Calculator calculator = new Calculator(historyStorage, notation);
        MainController mainController = new MainController(historyStorage, calculator);

        try {
            mainController.run();
        } catch (Exception e) {
            printWithLineBreak(e.getMessage());
        } finally {
            showQuitMessage();
        }
    }
}
