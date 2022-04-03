import calculation.CalculateService;
import calculation.calculator.engine.BigDecimalCalculator;
import calculation.calculator.expression.ArithmeticLogic;
import calculation.calculator.expression.NormalArithmeticLogic;
import calculation.calculator.expression.NormalExpressionService;
import calculation.io.BufferedIO;
import calculation.log.CalculationLogger;
import calculation.log.repository.CalculationDataRepository;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class CalculatorApplication {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedIO io = new BufferedIO(bufferedReader, bufferedWriter);

    ArithmeticLogic arithmeticLogic = new NormalArithmeticLogic();
    BigDecimalCalculator calEngine = new BigDecimalCalculator(new NormalExpressionService(arithmeticLogic));

    CalculationLogger calcLogService = new CalculationLogger(new CalculationDataRepository());

    new CalculateService(calEngine, calcLogService, io, io).run();
  }
}
