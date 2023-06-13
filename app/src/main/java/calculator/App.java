package calculator;

import static calculator.view.OutputView.printWithLineBreak;
import static calculator.view.OutputView.showQuitMessage;

import calculator.controller.MainController;
import calculator.service.Calculator;

public class App {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        MainController mainController = new MainController(calculator);

        try {
            mainController.run();
        } catch (Exception e) {
            printWithLineBreak(e.getMessage());
        } finally {
            showQuitMessage();
        }
    }
}
