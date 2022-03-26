package programmers.calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import programmers.calculator.memory.MemoryImpl;
import programmers.calculator.processor.Processor;
import programmers.calculator.processor.register.BufferRegister;
import programmers.calculator.processor.register.OperatorRegister;
import programmers.calculator.processor.register.ResultRegister;

class ControlUnitTest {

  ControlUnit controlUnit = new ControlUnit(new WhiteSpaceParser(),
      new Processor(new BufferRegister(), new ResultRegister(), new OperatorRegister()),
      new MemoryImpl());

  @Test
  @DisplayName("연산 결과를 출력한다")
  void printHistory() {
    controlUnit.execute("1 + 2");
    String history = controlUnit.printHistory();

    assertEquals("1 + 2 = 3\n", history);
  }

  @ParameterizedTest
  @CsvSource({
      "3 + 4 * 5, 23",
      "1.23 + 4.56 * 5.78, 27.59",
      "-4 * 2 / -3, 2.67",
  })
  @DisplayName("연산한다")
  void execute(String input, String expected) {
    String result = controlUnit.execute(input);

    assertEquals(expected, result);
  }
}