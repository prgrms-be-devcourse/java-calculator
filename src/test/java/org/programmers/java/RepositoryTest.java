package org.programmers.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.java.repository.FormulaMemoryRepository;
import org.programmers.java.repository.FormulaRepository;

import java.util.Map;

public class RepositoryTest {

    FormulaRepository formulaRepository = new FormulaMemoryRepository();

    @Test
    @DisplayName("연산식과 결과 저장소에 저장")
    void save(){
        // given
        String formula = "3 + 6 / 2";
        String result = "6";

        // when
        formulaRepository.save(formula, result);

        // then
        Assertions.assertEquals(formula + " = " + result, formulaRepository.getFormulaList().get(0L));
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
