package calculator.domain.repository;

import calculator.domain.Expression;
import calculator.domain.repository.CalculatorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Calculator Repository 테스트")
public class CalculatorRepositoryTest {
    private CalculatorRepository calculatorRepository;

    @BeforeEach
    public void beforeEach() {
        calculatorRepository = new CalculatorRepository();
    }

    @Test
    void 계산이력저장후조회_값이일치한다면_성공() {
        // given
        Expression expression1 = new Expression("1 + 2 * 3");
        Expression expression2 = new Expression("3 * 2 - 1");

        // when
        calculatorRepository.save(expression1, 7);
        calculatorRepository.save(expression2, 5);
        Map<Expression, Integer> history = calculatorRepository.findAll();

        // then
        assertEquals(7, history.get(expression1));
        assertEquals(5, history.get(expression2));
    }
}
