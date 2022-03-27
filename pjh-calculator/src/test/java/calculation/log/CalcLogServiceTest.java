package calculation.log;

import calculation.model.CalcData;
import calculation.log.repository.CalcDataRepository;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalcLogServiceTest {

  LogService<CalcData> logService = new CalcLogService(new CalcDataRepository());
  ByteArrayOutputStream out = new ByteArrayOutputStream();

  @BeforeEach
  private void before() {
    System.setOut(new PrintStream(out));
  }

  // 로그 서비스를 통해 로그가 잘 저장되는지 확인한다.
  @Test
  public void logTest() {
    //when
    logService.log(new CalcData("1 + 2 + 3", new BigDecimal(6)));
    logService.printLogById(0L);

    //then
    Assertions.assertEquals("1 + 2 + 3 = 6", out.toString().trim());
  }

  @Test
  public void printLogTest() {

    logService.log(new CalcData("1 + 2 + 3", new BigDecimal(6)));
    logService.log(new CalcData("1 + 2", new BigDecimal(3)));
    logService.log(new CalcData("3 * 2 + 1", new BigDecimal(7)));
    logService.printLog();

    Assertions.assertEquals("1 + 2 + 3 = 6" + System.lineSeparator() +
        "1 + 2 = 3" + System.lineSeparator() +
        "3 * 2 + 1 = 7", out.toString().trim());
  }
}