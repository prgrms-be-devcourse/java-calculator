package calculator.service;

import calculator.domain.model.HistoryModel;
import calculator.domain.repository.CalculatorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationFindTest {

    private CalculatorRepository calculatorRepository;
    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorRepository = new CalculatorRepository();
        calculatorService = new CalculatorService(calculatorRepository, new CalculatorManager());
    }

    @Test
    @DisplayName("CalculatorService.getHistoryAll() - 모든 계산 기록 조회")
    void 모든_계산_기록_조회() {
        //given
        HistoryModel history1 = new HistoryModel("2+3", "5");
        HistoryModel history2 = new HistoryModel("4-1", "3");
        HistoryModel history3 = new HistoryModel("5*2", "10");
        List<HistoryModel> histories = Arrays.asList(history1, history2, history3);
        histories.forEach(calculatorRepository::save);

        //when, then
        assertEquals(histories, calculatorService.getHistoryAll());
    }
}
