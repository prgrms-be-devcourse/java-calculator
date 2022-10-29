package com.programmers.calculator.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.programmers.calculator.controller.ConsoleController;
import com.programmers.calculator.controller.io.ConsoleRequest;
import com.programmers.calculator.controller.io.ConsoleResponse;
import com.programmers.calculator.domain.CalculateHistory;
import com.programmers.calculator.repository.IdGenerator;
import com.programmers.calculator.repository.InMemoryRepository;
import com.programmers.calculator.repository.Repository;
import com.programmers.calculator.service.CalculatorService;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Console View 테스트")
class ConsoleViewTest {

    private ConsoleView consoleView;

    private ConsoleController controller;

    private Repository<Long, CalculateHistory> repository;

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeAll
    void setUp() {
        repository = new InMemoryRepository();
        controller = new ConsoleController(new CalculatorService(repository));
    }

    @AfterEach
    void clear() {
        repository.deleteAll();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("종료 테스트 - 0을 입력하면 예외를 던져 프로그램을 종료시킨다.")
    @Test
    void exitTestInput0ThrowException() {
        //given
        InputStream in = generateUserInput("0");
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        consoleView = new ConsoleView(controller, scanner);

        //when & then
        assertThrows(RuntimeException.class, () -> consoleView.show());

    }

    @DisplayName("종료 테스트 - 0 1 2 이외의 값을 입력하면 예외를 던져 프로그램을 종료시킨다")
    @ParameterizedTest
    @ValueSource(strings = {"3", "4", "5", "6", " ", "\n", "-1", "a", "b", "c", "*", ")"})
    void exitTestThrowException(String input) {
        //given
        InputStream in = generateUserInput(input);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        consoleView = new ConsoleView(controller, scanner);

        //when & then
        assertThrows(RuntimeException.class, () -> consoleView.show());
    }

    @DisplayName("조회 테스트 - 데이터가 없을 때 - 1을 입력하면 저장된 데이터가 없다는 메시지를 출력한다. ")
    @Test
    void inquiryTestNotSavedData() {
        //given
        InputStream in = generateUserInput("1");
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        consoleView = new ConsoleView(controller, scanner);
        //when then
        consoleView.show();

        assertEquals(getLastStringFromByteArrayOutputStream(), "저장된 데이터가 없습니다.");
    }

    @DisplayName("조회 테스트 - 데이터가 있을 때 저장된 데이터를 반환받는다.")
    @Test
    void inquiryTestSavedData() {
        //given
        InputStream in = generateUserInput("1");
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        consoleView = new ConsoleView(controller, scanner);
        String expressionStr1 = "1 + 1";
        Number result1 = 2;

        String expressionStr2 = "2 * 2 + 5 + 5";
        Number result2 = 14;

        repository.save(new CalculateHistory(IdGenerator.getInstance().generateId(), expressionStr1, result1));
        repository.save(new CalculateHistory(IdGenerator.getInstance().generateId(), expressionStr2, result2));

        //when
        consoleView.show();

        //then
        String outPut = output.toString();
        assertTrue(outPut.contains(expressionStr1 + " = " + result1));
        assertTrue(outPut.contains(expressionStr2 + " = " + result2));
    }

    @DisplayName("read() 테스트 - 스캐너로부터 입력을 받아 ConsoleRequest 를 반환한다.")
    @Test
    void readReturnConsoleRequestTest() {
        //given
        String input = "1";
        InputStream in = generateUserInput(input);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        consoleView = new ConsoleView(controller, scanner);

        //when
        ConsoleRequest read = consoleView.read();

        //then
        assertEquals(input, read.getExpression());
    }

    @DisplayName("write() 테스트 - Response 를 받아 System.out.println 로 출력한다.")
    @Test
    void writeTest() {
        //given
        Scanner scanner = new Scanner(System.in);
        consoleView = new ConsoleView(controller, scanner);

        String writeStr = "write";
        ConsoleResponse consoleResponse = new ConsoleResponse(writeStr);

        //when
        consoleView.write(consoleResponse);

        //then
        assertTrue(output.toString().contains(writeStr));
    }

    @DisplayName("계산 테스트 - 계산 식을 입력하면 결과를 돌려받는다.")
    @ParameterizedTest
    @CsvSource(value = {"10 + 10, 20", "10 * 10, 100", "30 * 10 + 700, 1000"})
    void calculateSuccessTest(String expressionStr, String result) {
        //given
        InputStream in = createInputStreamSequence("2", expressionStr);

        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        consoleView = new ConsoleView(controller, scanner);

        //when
        consoleView.show();

        //then
        assertEquals(result, getLastStringFromByteArrayOutputStream());
    }

    private String getLastStringFromByteArrayOutputStream() {
        String[] split = output.toString().split("\n");
        return split[split.length - 1];
    }

    private InputStream generateUserInput(final String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private InputStream createInputStreamSequence(String... inputs) {
        List<InputStream> inputStreams = Arrays.stream(inputs)
                .map(input -> this.generateUserInput(input + "\n"))
                .collect(Collectors.toList());

        return new SequenceInputStream(Collections.enumeration(inputStreams));
    }

}