package calculator.application;

import calculator.engine.controller.Controller;

public class Application {
    public static void main(String[] args) {
        Thread calculator = new Thread(new Controller());
        calculator.start();
        calculator.interrupt();
    }
}
