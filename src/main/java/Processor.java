import model.Calculator;
import view.View;

public class Processor {
    private final View view;
    private final Calculator calculator;

    public Processor() {
        this.view = new View();
        this.calculator = new Calculator();
    }

    public void start() {

    }
}
