package calculator;

import calculator.engine.Calculator;
import calculator.exception.DivisionByZero;
import org.assertj.core.internal.bytebuddy.implementation.bytecode.Division;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @AfterEach
    public void afterEach() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("계산기능 테스트")
    void test_01() throws Exception {
    }
}
