package com.programmers.devcourse.processor;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringTokenProcessorTest {

  StringTokenProcessor processor;

  @BeforeEach
  void setup() {
    processor = new StringTokenProcessor();
  }

  @Test
  void testProcessReturnProperResult() {
    Assertions.assertEquals(processor.process(Arrays.asList("3.5", "+", "1")), 4.5);
    Assertions.assertEquals(processor.process(Arrays.asList("5.5", "-", "1")), 4.5);
    Assertions.assertEquals(processor.process(Arrays.asList("7.5", "+", "1", "*", "92.5")), 100.0);
  }

  @Test
  void testProcessReturnDifferentResult() {

    Assertions.assertNotEquals(processor.process(Arrays.asList("7.5", "+", "1", "*", "92.5")),
        100.1);
  }
}