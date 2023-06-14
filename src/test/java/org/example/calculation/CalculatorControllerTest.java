package org.example.calculation;
import org.example.controller.CalculatorController;
import org.example.io.ConsoleOutput;
import org.example.io.Input;
import org.example.io.Output;
import org.example.repository.MemoryEquationRepository;
import org.example.repository.EquationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculatorControllerTest {
    private Compute compute;
    private Input input;
    private Output output;
    private EquationRepository equationRepository;
    private CalculatorController calculatorController;

    //터미널 출력값 검증용
    public PrintStream originalOut;
    public ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        compute = new ArithmeticCompute();
        input = mock(Input.class);
        output = new ConsoleOutput();
        equationRepository = new MemoryEquationRepository();

        calculatorController = new CalculatorController(compute, input, output, equationRepository);

        // 기존 표준 출력 스트림 보관
        originalOut = System.out;

        // 캡처할 표준 출력을 위한 ByteArrayOutputStream 생성
        outputStream = new ByteArrayOutputStream();
        PrintStream captureStream = new PrintStream(outputStream);

        // 표준 출력 스트림을 재지정
        System.setOut(captureStream);
    }

    @AfterEach
    public void reset(){
        // 기존 표준 출력 스트림으로 복원
        System.setOut(originalOut);
    }

    @Test
    public void 계산기_통합테스트_연산값_테스트() throws IOException {
        when(input.selectAction()).thenReturn("2").thenReturn("3");
        when(input.getUserEquation()).thenReturn("3 - 9 / 3 + 2 * 7");

        calculatorController.run();

        // 캡처된 터미널 출력 값을 얻어옴
        String terminalOutput = outputStream.toString();

        // 예상 출력 값과 비교
        String expectedOutput = "14.0";
        assertThat(terminalOutput).contains(expectedOutput);
    }

    @Test
    public void 메모리에_저장된_식_조회_테스트() throws IOException{
        when(input.selectAction()).thenReturn("2").thenReturn("1").thenReturn("3");
        when(input.getUserEquation()).thenReturn("2 - 12 / 2 + 5 * 15");

        calculatorController.run();

        String terminalOutput = outputStream.toString();

        String expectedOutput = "2 - 12 / 2 + 5 * 15 = 71.0";
        assertThat(terminalOutput).contains(expectedOutput);
    }

    @Test
    public void divide_zero_예외처리_테스트() throws IOException{
        when(input.selectAction()).thenReturn("2").thenReturn("3");
        when(input.getUserEquation()).thenReturn("3 + 9 / 0");

        calculatorController.run();

        String terminalOutput = outputStream.toString();

        String expectedOutput = "잘못된 수식이 입력 되었습니다.";
        assertThat(terminalOutput).contains(expectedOutput);
    }

    @Test
    public void 연산자가_연속된_경우_예외처리() throws IOException{
        when(input.selectAction()).thenReturn("2").thenReturn("3");
        when(input.getUserEquation()).thenReturn("3 + + 9");

        calculatorController.run();

        String terminalOutput = outputStream.toString();

        String expectedOutput = "잘못된 수식이 입력 되었습니다.";
        assertThat(terminalOutput).contains(expectedOutput);
    }
}
