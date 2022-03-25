package com.prgrms.ndy.repository;

import com.prgrms.ndy.domain.Calculation;
import com.prgrms.ndy.domain.Command;
import com.prgrms.ndy.parsor.Parser;
import com.prgrms.ndy.parsor.RegexParser;
import org.assertj.core.data.Offset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HashMapCalculationRepositoryTest {

    HashMapCalculationRepository calculationRepository = new HashMapCalculationRepository();
    Parser parser = new RegexParser();
    Offset<Double> OFFSET = Offset.offset(0.000_001);

    @ParameterizedTest
    @CsvSource(value = {
            "1.0 + 2.0 + 3.0 + 4.0, 10, 1",
            "-1.0 - -2.0 * -3.0 + 4.8, -2.2, 1",
    })
    void 하나_저장하고_Id_생성검증(String expr, double result, long expectedId) {
        Command command = parser.parse(expr);
        calculationRepository.save(new Calculation(command, result));

        List<Calculation> calcs = calculationRepository.findAll();
        for (Calculation calc : calcs) {
            System.out.println("calc = " + calc);
        }

        assertThat(calcs.size()).isEqualTo(1);
        assertThat(calcs.get(0).getId()).isEqualTo(expectedId);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1.0 + 2.0 + 3.0 + 4.0, 10, 1,  -1.0 - -2.0 * -3.0 + 4.8, -2.2, 2",
    })
    void 두개_저장하고_아이디_생성_테스트(String expr1, double result1, long expectedId1, String expr2, double result2, long expectedId2) {
        Command command1 = parser.parse(expr1);
        Command command2 = parser.parse(expr2);

        calculationRepository.save(new Calculation(command1, result1));
        calculationRepository.save(new Calculation(command2, result2));

        List<Calculation> calcs = calculationRepository.findAll();
        for (Calculation calc : calcs) {
            System.out.println("calc = " + calc);
        }

        assertThat(calcs.size()).isEqualTo(2);
        assertThat(calcs.get(0).getId()).isEqualTo(expectedId1);
        assertThat(calcs.get(1).getId()).isEqualTo(expectedId2);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1.0 + 2.0 + 3.0 + 4.0, 10",
            "-1.0 - -2.0 * -3.0 + 4.8, -2.2",
    })
    void 하나_저장하고_FindAll(String expr, double result) {
        Command command = parser.parse(expr);
        calculationRepository.save(new Calculation(command, result));

        List<Calculation> calcs = calculationRepository.findAll();
        for (Calculation calc : calcs) {
            System.out.println("calc = " + calc);
        }

        assertThat(calcs.size()).isEqualTo(1);
        assertThat(calcs.get(0).getCommand().toString()).isEqualTo(expr);
        assertThat(calcs.get(0).getResult().doubleValue()).isCloseTo(result,OFFSET);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1.0 + 2.0 + 3.0 + 4.0, 10, -1.0 - -2.0 * -3.0 + 4.8, -2.2",
    })
    void 두개_저장하고_FindAll(String expr1, double result1, String expr2, double result2) {
        Command command1 = parser.parse(expr1);
        Command command2 = parser.parse(expr2);

        calculationRepository.save(new Calculation(command1, result1));
        calculationRepository.save(new Calculation(command2, result2));

        List<Calculation> calcs = calculationRepository.findAll();
        for (Calculation calc : calcs) {
            System.out.println("calc = " + calc);
        }

        assertThat(calcs.size()).isEqualTo(2);
        assertThat(calcs.get(0).getCommand().toString()).isEqualTo(expr1);
        assertThat(calcs.get(0).getResult().doubleValue()).isCloseTo(result1,OFFSET);

        assertThat(calcs.get(1).getCommand().toString()).isEqualTo(expr2);
        assertThat(calcs.get(1).getResult().doubleValue()).isCloseTo(result2,OFFSET);
    }
}