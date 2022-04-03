package calculator.serviceImpl;

import calculator.config.AppConfig;
import calculator.engine.model.OperatorOrder;
import calculator.repository.CalculationRepository;
import calculator.engine.calculate.Calculate;
import calculator.engine.parser.Parser;
import calculator.engine.sorter.Sorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

class CalculatorTest {

    AppConfig appConfig = new AppConfig();

    private final Calculate calculate = appConfig.calculation();
    private final Parser parser = appConfig.parser();
    private final Sorter sorter = appConfig.sorter();
    private final CalculationRepository calculationRepository = appConfig.calculationRepository();

    private void initCalculateData(String[] splitArr, Double[] nums, List<OperatorOrder> orderedOperators) {
        for (int i = 0; i < splitArr.length; i++) {
            if (i % 2 == 0)
                nums[i] = Double.valueOf(splitArr[i]);
            else {
                orderedOperators.add(new OperatorOrder(splitArr[i].charAt(0), i));
            }
        }
    }

    private double exec(String command) {
        String parsedCmd = parser.parse(command);
        String[] splitArr = parsedCmd.split(" ");
        Double[] nums = new Double[splitArr.length];
        List<OperatorOrder> orderedOperators = new ArrayList<>();
        initCalculateData(splitArr, nums, orderedOperators);
        sorter.sort(orderedOperators);
        double result = calculate.calculate(nums, orderedOperators);
        return result;
    }

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
        Double result = exec(command);
        calculationRepository.save(command, result);
        //then
        List<String> all = calculationRepository.findAll();
        Assertions.assertEquals(1, all.size());
    }

}