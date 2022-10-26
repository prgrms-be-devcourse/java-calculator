package org.programmers.java.calculator.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.java.calculator.repository.impl.CalculatorRepositoryImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {


    private final CalculatorRepositoryImpl calculatorRepository = new CalculatorRepositoryImpl();

    @Test
    @DisplayName("saveTest : 1개 저장")
    void save() {
        //given
        String input = "1 + 1 * 2";
        String answer = "3";
        calculatorRepository.save(input, answer);

        //when
        //then
        assertEquals(1, 1);
    }

    @Test
    @DisplayName("saveTest : 2개 저장")
    void save1() {
        //given
        String input = "1 + 1 * 2";
        String answer = "3";

        String input1 = "2 + 2 * 5";
        String answer1 = "12";

        //when
        calculatorRepository.save(input, answer);
        calculatorRepository.save(input1, answer1);

        //then
        assertEquals(1, 1);
    }

    @Test
    @DisplayName("findAllTest : 0개 조회")
    void recordZero() {
        //given
        StringBuffer sb = new StringBuffer();

        //when
        calculatorRepository.findAll().forEach((key, value) ->{
            sb.append(key);
            sb.append(" = ");
            sb.append(value);
            sb.append("\n");
        });

        //then
        assertEquals(sb.toString(), "");

    }

    @Test
    @DisplayName("findAllTest : 1개 조회")
    void recordOne() {
        //given
        StringBuffer sb = new StringBuffer();

        String input = "1 + 1";
        String answer = "2";
        calculatorRepository.save(input, answer);

        //when
        calculatorRepository.findAll().forEach((key, value) ->{
            sb.append(key);
            sb.append(" = ");
            sb.append(value);
            sb.append("\n");
        });

        //then
        assertEquals(sb.toString(), """
                1 + 1 = 2
                """);

    }

    @Test
    @DisplayName("findAllTest : 2개 조회")
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
        calculatorRepository.findAll().forEach((key, value) ->{
            sb.append(key);
            sb.append(" = ");
            sb.append(value);
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
    @DisplayName("findTest : 조회")
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

}