import model.Calculator;
import model.Command;
import view.View;

public class Processor {
    private final View view;
    private final Calculator calculator;

    public Processor() {
        this.view = new View();
        this.calculator = new Calculator();
    }

    public void start() {
        while (true) {
            try {
                view.printInfoMessage();
                Command command = view.commandReader();
                view.printNewLine();

                if (command.equals(Command.HISTORY_COMMAND)) {

                }
                if (command.equals(Command.CALCULATE_COMMAND)) {
                    String expression = view.expressionReader();
                    int result = calculator.calculate(expression);
                    view.printAnswer(result);
                }
            } catch (RuntimeException e) {
                System.out.println("\n" + e.getMessage() + "\n");
            }
        }
    }
}
