package org.programmers.java.calculator.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.java.calculator.repository.impl.CalculatorRepositoryImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {


    private final CalculatorRepositoryImpl calculatorRepository = new CalculatorRepositoryImpl();

    @BeforeEach
    void setup() {
        }

    @Test
    @DisplayName("기록을 출력합니다. - 제로 저장 예시")
    void recordZero() {
        //given
        StringBuffer sb = new StringBuffer();

        //when
        calculatorRepository.findAll().forEach(i -> sb.append(i));

        //then
        assertEquals(sb.toString(), "");

    }

    @Test
    @DisplayName("기록을 출력합니다. - 하나 저장 예시")
    void recordOne() {
        //given
        StringBuffer sb = new StringBuffer();

        String input = "1 + 1";
        String answer = "2";
        calculatorRepository.save(input, answer);

        //when
        calculatorRepository.findAll().forEach(i -> sb.append(i));

        //then
        assertEquals(sb.toString(), "1 + 1 = 2");

    }

    @Test
    @DisplayName("두개의 기록을 출력합니다. - 두개 저장 예시")
    void recordTwo() {
        //given
        StringBuffer sb = new StringBuffer();

        String input = "1 + 1";
        String answer = "2";
        calculatorRepository.save(input, answer);

        input = "2 + 2";
        answer = "4";
        calculatorRepository.save(input, answer);

        //when
        calculatorRepository.findAll().forEach(i -> sb.append(i));

        //then
        assertEquals(
                sb.toString(),
                "1 + 1 = 2" +
                "2 + 2 = 4"
        );
    }

    @Test
    @DisplayName("하나의 기록을 찾아주세요!")
    void find() {
        //given
        String input = "1 + 1";
        String answer = "2";
        calculatorRepository.save(input, answer);

        //when
        Optional<String> find = calculatorRepository.find("1 + 1");

        //then
        assertEquals(find.get(), "2");

    }

    @Test
    @DisplayName("저장 해주세요!")
    void save() {

    }
}