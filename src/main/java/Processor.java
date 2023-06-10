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

            } catch (RuntimeException e) {
                System.out.println("\n" + e.getMessage() + "\n");
            }
        }


    }
}
