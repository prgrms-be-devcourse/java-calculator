import controller.CalculatorController;
import io.CalculatorInput;
import io.CalculatorOutput;
import io.CalculatorPrintOutput;
import io.CalculatorScannerInput;
import model.calculation.Calculation;
import model.calculation.CalculationImpl;
import model.converter.Converter;
import model.converter.PostfixConverter;

public class CalculatorApplication {
    public static void main(String[] args) {
        CalculatorInput input = new CalculatorScannerInput();
        CalculatorOutput output = new CalculatorPrintOutput();
        Converter converter = new PostfixConverter();
        Calculation calculation = new CalculationImpl();

        new CalculatorController(input, output, converter, calculation).runProgram();
    }
}
