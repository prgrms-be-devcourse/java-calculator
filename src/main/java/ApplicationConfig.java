import calculator.Calculator;
import calculator.DevCalculator;
import controller.CalculatorController;
import repository.MemoryResultRepository;
import repository.ResultRepository;
import view.CalculatorView;
import view.io.ConsoleIO;
import view.io.IO;

public class ApplicationConfig {

    private ResultRepository repository;
    private Calculator calculator;
    private CalculatorController controller;
    private IO io;
    private CalculatorView view;

    public ApplicationConfig() {
        init();
    }

    private void init() {
        repository = new MemoryResultRepository();
        calculator = new DevCalculator(repository);
        controller = new CalculatorController(calculator);
        io = new ConsoleIO();
        view = new CalculatorView(io, controller);
    }

    public CalculatorView getView() {
        return view;
    }
}