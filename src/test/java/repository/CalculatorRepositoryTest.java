package repository;

import entity.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CalculatorRepositoryTest {
    CalculatorRepository calculatorRepository = new CalculatorMemoryRepository();

    @BeforeEach
    void before(){
        calculatorRepository.clear();
    }

    @ParameterizedTest
    @DisplayName("데이터 저장 테스트")
    @CsvSource({
            "0, a, resultA",
            "1, b, resultB",
            "2, c, resultC",
            "3, d, resultD",
            "4, e, resultE"
    })
    void save(Long id, String formula, String result) {
        Data data = new Data(id, formula, result);

        String saveResult = calculatorRepository.save(data);

        assertThat(saveResult).isEqualTo(data.getResult());
    }

    @ParameterizedTest
    @DisplayName("ID로 데이터 조회 테스트")
    @CsvSource({
            "0, a, resultA",
            "1, b, resultB",
            "2, c, resultC",
            "3, d, resultD",
            "4, e, resultE"
    })
    void findById(Long id, String formula, String result) {
        Data data = new Data(id, formula, result);
        calculatorRepository.save(data);

        Data findData = calculatorRepository.findById(id);

        assertThat(findData).isEqualTo(data);
    }

    @Test
    @DisplayName("저장 데이터 모두 조회 테스트")
    void findAll() {

        List<Data> dataList = new ArrayList<>();

        for (Long id = 0L; id < 10; id++) {
            Data data = new Data(id, "formula" + id, "result" + id);
            dataList.add(data);
            calculatorRepository.save(data);
        }

        List<Data> findDataList = calculatorRepository.findAll();

        assertThat(findDataList).isEqualTo(dataList);
    }

    @Test
    @DisplayName("저장소 초기화 테스트")
    void clear() {
        calculatorRepository.clear();
        assertThat(calculatorRepository.findAll().isEmpty()).isTrue();
    }
}