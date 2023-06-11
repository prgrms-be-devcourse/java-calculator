package calculator;

import static calculator.view.OutputView.printWithLineBreak;
import static calculator.view.OutputView.showQuitMessage;

import calculator.controller.MainController;

public class App {

    public static void main(String[] args) {
        try {
            new MainController().run();
        } catch (Exception e) {
            printWithLineBreak(e.getMessage());
        } finally {
            showQuitMessage();
        }
    }
}
