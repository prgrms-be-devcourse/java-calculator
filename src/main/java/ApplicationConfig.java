import calculator.Calculator;
import calculator.DevCalculator;
import controller.CalculatorController;
import repository.MemoryResultRepository;
import repository.ResultRepository;
import view.CalculatorView;
import view.io.ConsoleIO;
import view.io.IO;

public class ApplicationConfig {

    private final CalculatorController controller = new CalculatorController(new DevCalculator(new MemoryResultRepository()));
    private final CalculatorView view = new CalculatorView(new ConsoleIO(), controller);

    public CalculatorView getView() {
        return view;
    }
}