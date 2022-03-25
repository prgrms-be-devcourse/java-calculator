package calculator.serviceImpl;

import calculator.config.AppConfig;
import calculator.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class CalculationServiceImplTest {

    AppConfig appConfig = new AppConfig();
    CalculateService calculationService = appConfig.calculationService();

    @ParameterizedTest
    @CsvSource({ // given
            " 1  +      2, 1 + 2 = 3.0",
            "      -1     +    20, -1 + 20 = 19.0",
            "1 + 2 + 3 * 6 /          10, 1 + 2 + 3 * 6 / 10 = 4.8",
            "  2147483647 - 2 1 4 7483648, 2147483647 - 2147483648 = -1.0",
            "1+1-2+3*6/2, 1 + 1 - 2 + 3 * 6 / 2 = 9.0",
            "1+1-2+3*6/6, 1 + 1 - 2 + 3 * 6 / 6 = 3.0",
            "        1 + 2          * 3, 1 + 2 * 3 = 7.0",
            "-300-    200, -300 - 200 = -500.0",
    })
    public void 통합_테스트_성공(String command, String expected) throws Exception {
        //when
        calculationService.calculate(command);
        //then
        List<String> all = calculationService.findAll();
        Assertions.assertEquals(expected, all.get(0));
    }

}