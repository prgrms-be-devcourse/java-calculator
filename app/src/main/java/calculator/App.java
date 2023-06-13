package calculator;

import static calculator.view.OutputView.printWithLineBreak;
import static calculator.view.OutputView.showQuitMessage;

import calculator.controller.MainController;
import calculator.service.Calculator;
import calculator.service.HistoryReader;
import calculator.storage.HistoryStorage;

public class App {

    public static void main(String[] args) {
        HistoryStorage historyStorage = new HistoryStorage();
        HistoryReader historyReader = new HistoryReader(historyStorage);
        Calculator calculator = new Calculator(historyStorage);
        MainController mainController = new MainController(historyReader, calculator);

        try {
            mainController.run();
        } catch (Exception e) {
            printWithLineBreak(e.getMessage());
        } finally {
            showQuitMessage();
        }
    }
}
