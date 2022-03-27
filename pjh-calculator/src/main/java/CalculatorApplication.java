import calculation.CalculateService;
import calculation.io.BufferedIO;
import calculation.calculator.engine.BigDecimalCalculator;
import calculation.calculator.expression.ArithmeticLogic;
import calculation.calculator.expression.NormalExpressionService;
import calculation.calculator.expression.NormalArithmeticLogic;
import calculation.log.CalcLogService;
import calculation.log.repository.CalcDataRepository;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class CalculatorApplication {

  public static void main(String[] args) throws IOException {

    // 표준 입출력으로 세팅
    BufferedIO io = new BufferedIO(new BufferedReader(new InputStreamReader(System.in)), new BufferedWriter(new OutputStreamWriter(System.out)));

    // 계산기 로직과 엔진 세팅
    ArithmeticLogic arithmeticLogic = new NormalArithmeticLogic();
    BigDecimalCalculator calEngine = new BigDecimalCalculator(new NormalExpressionService(arithmeticLogic));

    //로그 서비스 세팅
    CalcLogService calcLogService = new CalcLogService(new CalcDataRepository());

    //계산기 서비스 실행
    new CalculateService(calEngine, calcLogService, io, io).run();
  }
}
