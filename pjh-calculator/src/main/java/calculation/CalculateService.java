package calculation;

import calculation.calculator.engine.BigDecimalCalculator;
import calculation.io.Input;
import calculation.io.Output;
import calculation.model.CalculationData;
import calculation.log.Logger;
import java.io.IOException;
import java.util.NoSuchElementException;

public class CalculateService {

  private final BigDecimalCalculator calculator;
  private final Logger<CalculationData> logService;
  private final Input input;
  private final Output output;


  public CalculateService(BigDecimalCalculator calculator, Logger logService, Input input, Output output) {
    this.calculator = calculator;
    this.logService = logService;
    this.input = input;
    this.output = output;
  }

  public void run() throws IOException {
    while (true) {
      try {
        output.printCommand();
        doCommand(input.inputCommandType("선택 : "));
      } catch (IllegalArgumentException e) {
        output.printErrorMsg(e.getMessage());
      } catch (ArithmeticException e) {
        output.printErrorMsg("0으로 나눌 수 없습니다.");
      } catch (NoSuchElementException e) {
        break;
      } catch (IOException e) {
        output.printErrorMsg("입출력 오류가 발생했습니다.");
        break;
      }
    }
  }

  private void doCommand(int type) throws IOException {
    if (type != 1 && type != 2) {
      throw new IllegalArgumentException("잘못된 명령어 입력 입니다.");
    }
    if (type == 1) {
      logService.printLog();
    } else {
      CalculationData calcData = calculator.execute(input.input());
      logService.log(calcData);
      output.printAnswer(calcData);
    }
  }
}
