package com.programmers.io;

import static org.assertj.core.api.Assertions.assertThat;

import com.programmers.domain.CalculatorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

class ConsoleTest {

    private static final String MENU_MESSAGE = "1. 조회\n2. 계산\n3. 종료\n";
    private static final String MENU_SELECTION_MESSAGE = "선택 : ";
    private static final String TERMINATION_MESSAGE = "계산기 프로그램을 종료합니다.";

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final InputStream inputStream = System.in;
    private final PrintStream printStream = System.out;

    Console console = new Console();

    @BeforeEach
    public void before() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void after() {
        System.setOut(printStream);
        System.setIn(inputStream);
    }

    @Test
    void 메뉴를_출력한다() {
        //given
        //when
        console.printMenu();

        //then
        assertThat(outputStream.toString()).contains(MENU_MESSAGE);
        assertThat(outputStream.toString()).contains(MENU_SELECTION_MESSAGE);
    }

    @ValueSource(strings = {"1", "2", "3"})
    @ParameterizedTest
    void 메뉴_번호를_입력받는다(String input) {
        //given
        //when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        try {
            console.getSelection();

            assertThat(outputStream.toString()).contains(MENU_MESSAGE);
            assertThat(outputStream.toString()).contains(MENU_SELECTION_MESSAGE);
            assertThat(outputStream.toString()).contains(input);
        } catch (NoSuchElementException ignore) {
        }
    }

    @CsvSource(value = {
            "1 + 2 + 3 : 1+2+3",
            "2 * 44 - 5 : 2*44-5",
            "3 * 3 / 4 : 3*3/4"}, delimiter = ':')
    @ParameterizedTest
    void 계산식을_입력받고_빈_칸을_제거한_후_반환한다(String input, String expected) {
        //given
        //when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        try {
            String result = console.getExpressionSpaceRemoved();

            assertThat(result).isEqualTo(expected);
        } catch (NoSuchElementException ignore) {
        }
    }

    @CsvSource(value = {
            "1 + 2       + 3 : 1+2+3",
            "2 *   44 - 5 : 2*44-5",
            "3 *    3 / 4 : 3*3/4"}, delimiter = ':')
    @ParameterizedTest
    void 빈_칸을_제거한다(String input, String expected) {
        //given
        //when
        //then
        String result = console.removeSpace(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 종료_메시지를_출력한다() {
        //given
        //when
        console.printTermination();

        //then
        assertThat(outputStream.toString()).contains(TERMINATION_MESSAGE);
    }

    @Test
    void 결과를_출력한다() {
        //given
        //when
        console.printResult(30);

        //then
        assertThat(outputStream.toString()).contains("30");
    }

    @Test
    void 저장된_계산_결과들을_출력한다() {
        //given
        CalculatorRepository calculatorRepository = new CalculatorRepository();
        calculatorRepository.save("1 + 1 * 2 = 3");
        calculatorRepository.save("1 + 9 * 5 = 46");
        calculatorRepository.save("4 * 2 + 6 = 14");

        //when
        console.getResults();

        //then
        assertThat(outputStream.toString()).contains("1 + 1 * 2 = 3");
        assertThat(outputStream.toString()).contains("1 + 9 * 5 = 46");
        assertThat(outputStream.toString()).contains("4 * 2 + 6 = 14");
    }
}