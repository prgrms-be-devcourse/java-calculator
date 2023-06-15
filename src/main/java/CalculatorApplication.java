import controller.CalculatorController;
import io.CalculatorInput;
import io.CalculatorOutput;
import io.CalculatorPrintOutput;
import io.CalculatorScannerInput;
<<<<<<< HEAD
=======
import model.calculation.Calculation;
import model.calculation.CalculationImpl;
import model.converter.Converter;
import model.converter.PostfixConverter;
import model.repository.CalculatorRepository;
import model.repository.MemoryCalculatorRepository;
>>>>>>> 580d76c (Feat : 계산기 저장소 스캘레톤 코드)

public class CalculatorApplication {
    public static void main(String[] args) {
        CalculatorInput input = new CalculatorScannerInput();
        CalculatorOutput output = new CalculatorPrintOutput();
<<<<<<< HEAD

        new CalculatorController(input, output).run();
=======
        Converter converter = new PostfixConverter();
        Calculation calculation = new CalculationImpl();
        CalculatorRepository repository = new MemoryCalculatorRepository();

        new CalculatorController(input, output, converter, calculation, repository).runProgram();
>>>>>>> 580d76c (Feat : 계산기 저장소 스캘레톤 코드)
    }
}
