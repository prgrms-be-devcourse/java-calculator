import model.Calculator;
import model.Command;
import model.HistoryStorage;
import view.View;

public class Processor {
    private final View view;
    private final Calculator calculator;
    private final HistoryStorage historyStorage;

    public Processor() {
        this.view = new View();
        this.calculator = new Calculator();
        this.historyStorage = new HistoryStorage();
    }

    public void start() {
        while (true) {
            try {
                view.printInfoMessage();
                Command command = view.commandReader();
                view.printNewLine();

                if (command.equals(Command.HISTORY_COMMAND)) {
                    String history = historyStorage.loadAll();
                    view.printHistory(history);
                    view.printNewLine();
                }
                if (command.equals(Command.CALCULATE_COMMAND)) {
                    String expression = view.expressionReader();
                    String result = calculator.calculate(expression);
                    historyStorage.save(expression, result);
                    view.printAnswer(result);
                }
            } catch (RuntimeException e) {
                System.out.println("\n" + e.getMessage() + "\n");
            }
        }
    }
}
