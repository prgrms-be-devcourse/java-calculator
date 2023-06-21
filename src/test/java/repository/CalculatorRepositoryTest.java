package repository;

import com.programmers.model.ExpressionResult;
import com.programmers.repository.CalculatorRepository;
import com.programmers.repository.MapCalculatorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorRepositoryTest {
    private CalculatorRepository calculatorRepository;

    @BeforeEach
    public void beforeEach() {
        calculatorRepository = new MapCalculatorRepository();

    }

    @Test
    void 조회_테스트() {
        //ExpressionResult 객체 저장
        ExpressionResult expressionResult = new ExpressionResult("3 + 4 / 1", 7);
        ExpressionResult expressionResult1 = new ExpressionResult("40 / 2 * 6", 120);

        List<ExpressionResult> list = new ArrayList<>();
        list.add(expressionResult);
        list.add(expressionResult1);

        calculatorRepository.save(expressionResult);
        calculatorRepository.save(expressionResult1);

        //조회
        List<ExpressionResult> histories = calculatorRepository.findAll();
        assertEquals(histories, list);
    }
}