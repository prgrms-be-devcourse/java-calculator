package com.programmers.java.service;

import com.programmers.java.repository.MemoryRepository;
import com.programmers.java.repository.Repository;
import com.programmers.java.tokenizer.Tokenizer;
import com.programmers.java.tokenizer.TokenizerImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceImplTest {

    Tokenizer tokenizer;
    CalculateService calculateService;

    @BeforeEach
    void beforeEach() {
        tokenizer = new TokenizerImpl();
        calculateService = new CalculateServiceImpl(tokenizer);
    }

    @Test
    void 중위표기식_후위표기식_변환_테스트() {
        //given
        List<String> infixFormulaList = Arrays.asList("1", "+", "2", "*", "4");
        List<String> expectedResult = Arrays.asList("1", "2", "4", "*", "+");

        //when
        List<String> postFixFormulaList = calculateService.convertInfixToPostFix(infixFormulaList);

        //then
        Assertions.assertArrayEquals(postFixFormulaList.toArray(), expectedResult.toArray());
    }

    @Test
    @DisplayName("계산식(중위표기식)을 파라미터로 받고 후위표기식으로 변환 후 계산하는 테스트")
    void calculateFormulaTest() {
        //given
        String formula = "1 + 2 * 4";
        int expectedResult = 9;

        //when
        int result = calculateService.calculateFormula(formula);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }
}