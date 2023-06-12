import controller.CalculatorController;
import io.CalculatorInput;
import io.CalculatorOutput;
import io.CalculatorPrintOutput;
import io.CalculatorScannerInput;

public class CalculatorApplication {
    public static void main(String[] args) {
        CalculatorInput input = new CalculatorScannerInput();
        CalculatorOutput output = new CalculatorPrintOutput();

        new CalculatorController(input, output).run();
    }
}
