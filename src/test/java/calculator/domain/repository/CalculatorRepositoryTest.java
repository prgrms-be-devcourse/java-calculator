package calculator.domain.repository;

import calculator.domain.model.HistoryModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorRepositoryTest {

    private CalculatorRepository calculatorRepository;

    @BeforeEach
    void setUp() {

        calculatorRepository = new CalculatorRepository();
    }

    @Test
    void SUCCESS_계산기_저장소에_값_저장_및_조회() {

        //then
        final HistoryModel history1 = new HistoryModel(
                "1+2",
                "3"
        );
        final HistoryModel history2 = new HistoryModel(
                "21/3",
                "7"
        );
        calculatorRepository.save(history1);
        calculatorRepository.save(history2);

        //when
        List<HistoryModel> histories = calculatorRepository.findAll();

        //then
        assertEquals(histories.size(), 2);
        assertEquals(histories.get(0), history1);
        assertEquals(histories.get(1), history2);
    }
}
