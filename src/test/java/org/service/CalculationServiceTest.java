package org.service;

import org.domain.model.Calculator;
import org.domain.repository.CalculationRepository;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationServiceTest {

    @Test
    void SUCCESS_getCalculationsAll_메소드로_모든_계산_기록_조회() {

        //given
        Calculator calculator1 = new Calculator("2+3", "5");
        Calculator calculator2 = new Calculator("4-1", "3");
        Calculator calculator3 = new Calculator("5*2", "10");
        List<Calculator> calculators = Arrays.asList(calculator1, calculator2, calculator3);

        CalculationRepository calculationRepository = new CalculationRepository();
        calculators.forEach(calculationRepository::save);

        CalculationService calculationService = new CalculationService(calculationRepository);

        //when
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();   //임시 버퍼 생성
        PrintStream printStream = new PrintStream(outputStream);            //출력 내용 캡처
        System.setOut(printStream);                                         //sout 출력 시, 버퍼에 저장
        calculationService.getCalculationsAll();
        System.setOut(System.out);                                          //기본 출력 복원.

        String expectedOutput = "" +
                "2+3=5\n" +
                "4-1=3\n" +
                "5*2=10\n";

        //then
        assertEquals(outputStream.toString(), expectedOutput);
    }
}
