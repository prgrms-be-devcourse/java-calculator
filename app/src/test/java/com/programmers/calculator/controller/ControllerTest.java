package com.programmers.calculator.controller;

import com.programmers.calculator.AppConfig;
import com.programmers.calculator.domain.OperationResult;
import com.programmers.calculator.model.ArithmeticOperationCalculator;
import com.programmers.calculator.repository.MemoryResultRepository;
import com.programmers.calculator.repository.ResultRepository;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.programmers.calculator.view.Console;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    ResultRepository repository;
    Controller controller;

    @BeforeEach
    void beforeEach() {
        repository = new MemoryResultRepository();
        controller = new Controller(repository, new Console(), new Console(), new ArithmeticOperationCalculator());
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void afterEach() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    @DisplayName("이전에 요청되었던 연산결과를 출력한다.")
    void printHistory() {
        // given
        OperationResult operationResult = new OperationResult();
        operationResult.setFormula("1 + 1");
        operationResult.setResult("2");

        // when, then
        repository.save(operationResult);
        controller.printHistory();

        Assertions.assertEquals(output.toString(), operationResult.toString()+"\r\n");
    }

    @Test
    @DisplayName("이전에 연산결과가 존재하지 않으면 특정 문장을 출력한다.")
    void printNoHistory() {
        controller.printHistory();

        Assertions.assertEquals("출력할 결과가 없습니다.\r\n", output.toString());
    }
}