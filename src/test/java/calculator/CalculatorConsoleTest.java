package calculator;

import calculator.model.calculator.CalculationResult;
import calculator.repository.CalculationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorConsoleTest {

    private static ByteArrayOutputStream outputMessage;
    private static final CalculatorConsole console = new CalculatorConsole();
    private static CalculationRepository repository;

    private static final String NEW_LINE = "\r\n";


    @BeforeEach
    void setUpOutputStreams(){
        repository = new CalculationRepository();
        outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
        System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정
    }

    @AfterEach
    void restoresStreams(){
        System.setOut(System.out);
    }

    @Test
    @DisplayName("콘솔에 메뉴 출력하기")
    void putMenu() {
        console.putMenu();
        assertEquals("0. 종료" + NEW_LINE + "1. 조회" + NEW_LINE + "2. 계산", outputMessage.toString().strip());

    }

    @Test
    @DisplayName("계산 이력 콘솔에 출력하기")
    void showCalculationResult() {
        String expression1 = "3 + 5";
        Integer answer1 = 8;

        String expression2 = "5 * 2";
        Integer answer2 = 10;

        repository.save(new CalculationResult(expression1, answer1));
        repository.save(new CalculationResult(expression2, answer2));


        console.showCalculationResult(repository.findAll());
        assertEquals("3 + 5 = 8" + NEW_LINE + "5 * 2 = 10", outputMessage.toString().strip());
    }

    @Test
    @DisplayName("계산의 수식과 답 콘솔에 출력하기")
    void showResult() {
        String expression = "3 + 5";
        Integer answer = 8;

        CalculationResult result = new CalculationResult(expression, answer);
        repository.save(result);


        console.showResult(result.toString());
        assertEquals("3 + 5 = 8", outputMessage.toString().strip());
    }
}