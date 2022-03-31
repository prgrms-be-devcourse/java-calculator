package calculator;

import calculator.engine.Calculator;
import calculator.engine.model.HistoryDatabase;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        HistoryDatabase database = new HistoryDatabase();

        new Calculator(console, console, database).run();
    }
}
