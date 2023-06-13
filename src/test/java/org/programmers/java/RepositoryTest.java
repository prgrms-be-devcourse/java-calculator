package org.programmers.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.programmers.java.repository.FormulaMemoryRepository;
import org.programmers.java.repository.FormulaRepository;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepositoryTest {
    FormulaRepository formulaRepository = new FormulaMemoryRepository();

    @ParameterizedTest
    @DisplayName("연산식과 결과 저장소에 저장")
    @CsvSource(value={"3 + 6 / 2 : 6", "10 / 2 * 5 - 3 : 22"}, delimiter = ':')
    void save(String formula, String result){
        // when
        formulaRepository.save(formula, result);

        // then
        assertEquals(formula + " = " + result, formulaRepository.getFormulaList().get(0L));
    }

    @Test
    @DisplayName("연산식, 결과 모두 출력하기")
    void getFormulaList(){
        // given
        String formula1 = "3 + 6 / 2";
        String result1 = "6";
        String formula2 = "10 / 2 * 5 - 3";
        String result2 = "22";

        Map<Long, String> formulaListExpect = Map.of(
                0L, "3 + 6 / 2 = 6",
                1L, "10 / 2 * 5 - 3 = 22"
        );

        // when
        formulaRepository.save(formula1, result1);
        formulaRepository.save(formula2, result2);

        // then
        Assertions.assertEquals(formulaListExpect, formulaRepository.getFormulaList());
    }
}
