package org.programmers.java.calculator.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.java.calculator.repository.impl.CalculatorRepositoryImpl;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceImplTest {


    private final CalculatorRepositoryImpl calculatorRepository = new CalculatorRepositoryImpl();

    @Test
    @DisplayName("하나의 값 저장 테스트")
    void saveOne() {
        //given
        String input = "1 + 1 * 2";
        String answer = "3";

        //when
        Long saveId = calculatorRepository.save(input, answer);

        //then
        assertEquals(0L, saveId);
    }

    @Test
    @DisplayName("2개의 값 저장 테스트")
    void saveTwo() {
        //given
        String input = "1 + 1 * 2";
        String answer = "3";

        String input1 = "2 + 2 * 5";
        String answer1 = "12";

        //when
        Long saveId0 = calculatorRepository.save(input, answer);
        Long saveId1 = calculatorRepository.save(input1, answer1);

        //then
        assertEquals(0L, saveId0);
        assertEquals(1L, saveId1);

    }

    @Test
    @DisplayName("없는 값 조회 테스트")
    void recordZero() {
        //given
        StringBuffer sb = new StringBuffer();

        //when
        calculatorRepository.findAll().forEach(find ->{
            sb.append(find);
            sb.append("\n");
        });

        //then
        assertEquals("",sb.toString(),"성공");

    }

    @Test
    @DisplayName("조회 테스트")
    void recordOne() {
        //given
        StringBuffer sb = new StringBuffer();

        String input = "1 + 1";
        String answer = "2";
        calculatorRepository.save(input, answer);

        //when
        calculatorRepository.findAll().forEach(find ->{
            sb.append(find);
            sb.append("\n");
        });

        //then
        assertEquals(sb.toString(), """
                1 + 1 = 2
                """);

    }

    @Test
    @DisplayName("다중 값 조회 테스트")
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
        calculatorRepository.findAll().forEach(find ->{
            sb.append(find);
            sb.append("\n");
        });

        //then
        assertEquals(
                sb.toString(),
                """
                        1 + 1 = 2
                        2 + 2 = 4
                        """
        );
    }

    @Test
    @DisplayName("이미 저장된 값 조회 테스트")
    void find() {
        //given
        String input = "1 + 1";
        String answer = "2";
        calculatorRepository.save(input, answer);

        //when
        Optional<String> find = calculatorRepository.find("1 + 1");

        //then
        assertEquals("2", find.get(), "성공");

    }

    @Test
    @DisplayName("같은 값 입력 하고 같은 값 출력 테스트")
    void test() {
        //given
        StringBuffer sb = new StringBuffer();

        String input = "1 + 1";
        String answer = "2";
        calculatorRepository.save(input, answer);

        String input1 = "1 + 1";
        String answer1 = "2";
        calculatorRepository.save(input1, answer1);

        //when
        calculatorRepository.findAll().forEach(find ->{
            sb.append(find);
            sb.append("\n");
        });

        //then
        assertEquals(sb.toString(), """
                1 + 1 = 2
                1 + 1 = 2
                """);

    }
}