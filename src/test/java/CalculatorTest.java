import Calculator.Calculator;
import Calculate.*;
import IO.Console;
import Validator.*;
import Record.RecordMemoryRepository;
import Record.RecordRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    @DisplayName("계산기 생성")
    void _1() {
        Console console = new Console();
        Validator validator = new RegularExpressionValidator();
        Calculate calculate = new StackCalculate();
        RecordRepository recordRepository = new RecordMemoryRepository();
        Calculator calculator = new Calculator(console, console, validator, calculate, recordRepository);
        assertThat(calculator).isNotNull();
    }
}