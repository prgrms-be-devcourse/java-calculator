package calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.entity.Notation;
import calculator.entity.PostfixNotation;
import calculator.storage.HistoryStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PostfixCalculatorTest {

    private Calculator calculator;
    private HistoryStorage historyStorage;
    private Notation notation;

    @BeforeEach
    void init() {
        historyStorage = new HistoryStorage();
        notation = new PostfixNotation();
        calculator = new Calculator(historyStorage, notation);
    }

    @DisplayName("후위표현식으로 계산할 때 정상적으로 결과 값이 나오는지 테스트")
    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource({
        "3 + 5, 8",
        "4 - 2, 2",
        "3 * 6, 18",
        "20 / 5, 4",
        "3 + 4 * 5 - 2 / 6 + 8, 31",
        "10 + 2 * 7 - 3 / 5 - 1, 23",
        "1 - 2 / 3 + 4 * 5, 21",
        "5 * 4 / 2 + 3 - 1, 12"
    })
    void integrationTestWithPostfixNotation(String expression, int answer) {
        int result = calculator.calculate(expression);

        assertEquals(result, answer);
    }
}
