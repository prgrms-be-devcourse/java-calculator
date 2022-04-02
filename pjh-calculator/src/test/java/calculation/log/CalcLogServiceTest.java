package calculation.log;

import static java.lang.System.lineSeparator;
import static org.assertj.core.api.Assertions.assertThat;

import calculation.log.repository.CalcDataRepository;
import calculation.model.CalculationData;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalcLogServiceTest {

  Logger<CalculationData> logService = new CalculationLogger(new CalcDataRepository());
  ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

  @BeforeEach
  private void before() {
    System.setOut(new PrintStream(outputStream));
  }

  @DisplayName("로그 서비스를 통한 로그 저장 테스트")
  @Test
  public void logTest() {
    //when
    logService.log(new CalculationData("1 + 2 + 3", new BigDecimal(6)));
    logService.printLogById(0L);

    //then
    assertThat(outputStream.toString().trim()).isEqualTo("1 + 2 + 3 = 6");
  }

  @DisplayName("로그 서비스를 통한 로그 출력 테스트")
  @Test
  public void printLogTest() {

    logService.log(new CalculationData("1 + 2 + 3", new BigDecimal(6)));
    logService.log(new CalculationData("1 + 2", new BigDecimal(3)));
    logService.log(new CalculationData("3 * 2 + 1", new BigDecimal(7)));
    logService.printLog();

    String expected = "1 + 2 + 3 = 6" + lineSeparator() + "1 + 2 = 3" + lineSeparator() + "3 * 2 + 1 = 7";

    assertThat(outputStream.toString().trim()).isEqualTo(expected);
  }
}