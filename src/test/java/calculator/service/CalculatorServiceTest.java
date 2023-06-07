package calculator.service;

import calculator.domain.repository.CalculatorRepository;
import calculator.domain.model.HistoryModel;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    private CalculatorRepository calculatorRepository = new CalculatorRepository();
    private CalculatorService calculatorService = new CalculatorService(calculatorRepository);

    @Test
    void SUCCESS_getCalculationsAll_메소드로_모든_계산_기록_조회() {

        //given
        HistoryModel history1 = new HistoryModel("2+3", "5");
        HistoryModel history2 = new HistoryModel("4-1", "3");
        HistoryModel history3 = new HistoryModel("5*2", "10");
        List<HistoryModel> histories = Arrays.asList(history1, history2, history3);
        histories.forEach(calculatorRepository::save);

        //when
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();   //임시 버퍼 생성
        PrintStream printStream = new PrintStream(outputStream);            //출력 내용 캡처
        System.setOut(printStream);                                         //sout 출력 시, 버퍼에 저장
        calculatorService.getHistoryAll();
        System.setOut(System.out);                                          //기본 출력 복원.

        String expectedOutput = "" +
                "2+3=5\n" +
                "4-1=3\n" +
                "5*2=10\n";

        //then
        assertEquals(outputStream.toString(), expectedOutput);
    }

    @Test
    void SUCCESS_실제_연산을_진행() {

        //then
        String formula = "4*5/4+7*2";

        //when
        calculatorService.calculate(formula);
        HistoryModel history = calculatorRepository.findAll().get(0);

        //then
        assertEquals(history.getFormula(), formula);
        assertEquals(history.getAnswer(), "19");
    }
}
